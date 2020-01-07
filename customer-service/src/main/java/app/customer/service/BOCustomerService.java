package app.customer.service;

import app.api.customer.BOCreateCustomerRequest;
import app.api.customer.BOCreateCustomerResponse;
import app.api.customer.BOGetCustomerResponse;
import app.api.customer.BOSearchCustomerRequest;
import app.api.customer.BOSearchCustomerResponse;
import app.api.customer.BOUpdateCustomerRequest;
import app.api.customer.BOUpdateCustomerResponse;
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
import app.customer.domain.Customer;

/**
 * @author Else
 */
public class BOCustomerService {
    @Inject
    Repository<Customer> customerRepository;

    public BOSearchCustomerResponse search(BOSearchCustomerRequest request) {
        BOSearchCustomerResponse response = new BOSearchCustomerResponse();
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
            query.where("last_name like ?", Strings.format("%{}%", request.lastName));
        }
        response.customers = query.fetch().stream().map(customer -> {
            BOSearchCustomerResponse.Customer c = new BOSearchCustomerResponse.Customer();
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


    public BOGetCustomerResponse get(Long id) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found,id=" + id));
        BOGetCustomerResponse response = new BOGetCustomerResponse();
        response.email = customer.email;
        response.firstName = customer.firstName;
        response.lastName = customer.lastName;
        response.id = customer.id;
        response.updatedTime = customer.updatedTime;

        return response;
    }

    public BOCreateCustomerResponse create(BOCreateCustomerRequest request) {
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

        BOCreateCustomerResponse response = new BOCreateCustomerResponse();
        response.id = customer.id;
        response.email = customer.email;
        response.firstName = customer.firstName;
        response.lastName = customer.lastName;
        response.updatedTime = customer.updatedTime;
        return response;
    }

    public BOUpdateCustomerResponse update(Long id, BOUpdateCustomerRequest request) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found,id=" + id));
        customer.updatedTime = LocalDateTime.now();
        customer.lastName = request.lastName;
        customer.firstName = request.firstName;
        customerRepository.partialUpdate(customer);

        BOUpdateCustomerResponse response = new BOUpdateCustomerResponse();
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
