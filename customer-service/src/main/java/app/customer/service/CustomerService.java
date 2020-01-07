package app.customer.service;

import app.api.OrderWebService;
import app.api.customer.CreateCustomerRequest;
import app.api.customer.CreateCustomerResponse;
import app.api.customer.GetCustomerResponse;
import app.api.customer.SearchCustomerRequest;
import app.api.customer.SearchCustomerResponse;
import app.api.customer.UpdateCustomerRequest;
import app.api.customer.UpdateCustomerResponse;
import app.domain.Customer;
import app.domain.CustomerStatus;
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
public class CustomerService {
    @Inject
    Repository<Customer> customerRepository;

    public SearchCustomerResponse search(SearchCustomerRequest request) {
        SearchCustomerResponse response = new SearchCustomerResponse();
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
            SearchCustomerResponse.Customer c = new SearchCustomerResponse.Customer();
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


    public GetCustomerResponse get(Long id) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found,id=" + id));
        GetCustomerResponse response = new GetCustomerResponse();
        response.email = customer.email;
        response.firstName = customer.firstName;
        response.lastName = customer.lastName;
        response.id = customer.id;
        response.updatedTime = customer.updatedTime;
        return response;
    }

    public CreateCustomerResponse create(CreateCustomerRequest request) {
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

        CreateCustomerResponse response = new CreateCustomerResponse();
        response.id = customer.id;
        response.email = customer.email;
        response.firstName = customer.firstName;
        response.lastName = customer.lastName;
        response.updatedTime = customer.updatedTime;
        return response;
    }

    public UpdateCustomerResponse update(Long id, UpdateCustomerRequest request) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found,id=" + id));
        customer.updatedTime = LocalDateTime.now();
        customer.lastName = request.lastName;
        customer.firstName = request.firstName;
        customerRepository.partialUpdate(customer);

        UpdateCustomerResponse response = new UpdateCustomerResponse();
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
