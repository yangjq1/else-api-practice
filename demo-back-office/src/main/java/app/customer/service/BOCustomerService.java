package app.customer.service;

import app.api.BOOrderAJAXWebService;
import app.api.customer.BOCreateCustomerAJAXRequest;
import app.api.customer.BOCreateCustomerAJAXResponse;
import app.api.customer.BOGetCustomerAJAXResponse;
import app.api.customer.BOSearchCustomerAJAXRequest;
import app.api.customer.BOSearchCustomerAJAXResponse;
import app.api.customer.BOUpdateCustomerAJAXRequest;
import app.api.customer.BOUpdateCustomerAJAXResponse;
import app.api.order.BOSearchOrderAJAXRequest;
import app.customer.domain.Customer;
import app.customer.domain.CustomerStatus;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.util.Strings;
import core.framework.web.exception.ConflictException;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Else
 */
public class BOCustomerService {
    @Inject
    Repository<Customer> customerRepository;
    @Inject
    BOOrderAJAXWebService orderWebService;

    public BOSearchCustomerAJAXResponse search(BOSearchCustomerAJAXRequest request) {
        BOSearchCustomerAJAXResponse response = new BOSearchCustomerAJAXResponse();
        Query<Customer> query = customerRepository.select();
        query.skip(request.skip);
        query.limit(request.limit);
        if (!Strings.isBlank(request.email)) {
            query.where("email = ?", request.email);
        }
        if (!Strings.isBlank(request.firstName)) {
            query.where("first_name like ?", Strings.format("%{}%", request.firstName));
        }
        if (!Strings.isBlank(request.lastName)) {
            query.where("last_name like ?", Strings.format("" + "%{}%", request.lastName));
        }
        response.customers = query.fetch().stream().map(customer -> {
            BOSearchCustomerAJAXResponse.Customer c = new BOSearchCustomerAJAXResponse.Customer();
            c.id = customer.id;
            c.email = customer.email;
            c.firstName = customer.firstName;
            c.lastName = customer.lastName;
            c.updatedTime = customer.updatedTime;
            return c;
        }).collect(Collectors.toList());
        response.total = query.count();
        return response;
    }


    public BOGetCustomerAJAXResponse get(Long id) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found,id=" + id));
        BOGetCustomerAJAXResponse response = new BOGetCustomerAJAXResponse();
        response.email = customer.email;
        response.firstName = customer.firstName;
        response.lastName = customer.lastName;
        response.id = customer.id;
        response.updatedTime = customer.updatedTime;

        BOSearchOrderAJAXRequest request = new BOSearchOrderAJAXRequest();
        request.customerId = id;
        response.orders = orderWebService.search(request).orders;
        return response;
    }

    public BOCreateCustomerAJAXResponse create(BOCreateCustomerAJAXRequest request) {
        Optional<Customer> dbCustomer = customerRepository.selectOne("email = ?", request.email);
        if (dbCustomer.isPresent()) {
            throw new ConflictException("customer already exists, email=" + request.email);
        }

        Customer customer = new Customer();
        customer.status = CustomerStatus.ACTIVE;
        customer.email = request.email;
        customer.firstName = request.firstName;
        customer.lastName = request.lastName;
        customer.updatedTime = LocalDateTime.now();
        customer.id = customerRepository.insert(customer).orElseThrow();

        BOCreateCustomerAJAXResponse response = new BOCreateCustomerAJAXResponse();
        response.id = customer.id;
        response.email = customer.email;
        response.firstName = customer.firstName;
        response.lastName = customer.lastName;
        response.updatedTime = customer.updatedTime;
        return response;
    }

    public BOUpdateCustomerAJAXResponse update(Long id, BOUpdateCustomerAJAXRequest request) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found,id=" + id));
        customer.updatedTime = LocalDateTime.now();
        customer.lastName = request.lastName;
        customer.firstName = request.firstName;
        customerRepository.partialUpdate(customer);

        BOUpdateCustomerAJAXResponse response = new BOUpdateCustomerAJAXResponse();
        response.email = customer.email;
        response.firstName = customer.firstName;
        response.lastName = customer.lastName;
        response.updatedTime = customer.updatedTime;
        return response;
    }

    public void delete(Long id) {
        customerRepository.delete(id);
    }

}
