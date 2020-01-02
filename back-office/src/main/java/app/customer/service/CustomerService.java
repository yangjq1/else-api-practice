package app.customer.service;

import app.api.BOCustomerWebService;
import app.api.customer.BOCreateCustomerRequest;
import app.api.customer.BOCreateCustomerResponse;
import app.api.customer.BOGetCustomerResponse;
import app.api.customer.BOSearchCustomerRequest;
import app.api.customer.BOSearchCustomerResponse;
import app.api.customer.BOUpdateCustomerRequest;
import app.api.customer.BOUpdateCustomerResponse;
import app.api.customer.CreateCustomerAJAXRequest;
import app.api.customer.CreateCustomerAJAXResponse;
import app.api.customer.GetCustomerAJAXResponse;
import app.api.customer.SearchCustomerAJAXRequest;
import app.api.customer.SearchCustomerAJAXResponse;
import app.api.customer.UpdateCustomerAJAXRequest;
import app.api.customer.UpdateCustomerAJAXResponse;
import app.api.order.SearchOrderAJAXRequest;
import app.api.order.SearchOrderAJAXResponse;
import app.order.service.OrderService;
import core.framework.inject.Inject;

import java.util.stream.Collectors;

/**
 * @author Else
 */
public class CustomerService {
    @Inject
    OrderService orderService;
    @Inject
    BOCustomerWebService customerWebService;

    public SearchCustomerAJAXResponse search(SearchCustomerAJAXRequest request) {
        BOSearchCustomerRequest boRequest = new BOSearchCustomerRequest();
        boRequest.email = request.email;
        boRequest.firstName = request.firstName;
        boRequest.lastName = request.lastName;
        boRequest.limit = request.limit;
        boRequest.skip = request.skip;

        BOSearchCustomerResponse boResponse = customerWebService.search(boRequest);

        SearchCustomerAJAXResponse response = new SearchCustomerAJAXResponse();
        response.customers = boResponse.customers.stream().map(item -> {
            SearchCustomerAJAXResponse.Customer customer = new SearchCustomerAJAXResponse.Customer();
            customer.email = item.email;
            customer.firstName = item.firstName;
            customer.id = item.id;
            customer.lastName = item.lastName;
            customer.updatedTime = item.updatedTime;
            return customer;
        }).collect(Collectors.toList());
        response.total = boResponse.total;
        return response;
    }


    public GetCustomerAJAXResponse get(Long id) {
        BOGetCustomerResponse boResponse = customerWebService.get(id);

        GetCustomerAJAXResponse response = new GetCustomerAJAXResponse();
        response.email = boResponse.email;
        response.firstName = boResponse.firstName;
        response.id = boResponse.id;
        response.lastName = boResponse.lastName;
        response.updatedTime = boResponse.updatedTime;

        SearchOrderAJAXRequest request = new SearchOrderAJAXRequest();
        request.customerId = id;
        SearchOrderAJAXResponse orderResponse = orderService.search(request);
        response.orders = orderResponse.orders.stream().map(item -> {
            GetCustomerAJAXResponse.Order order = new GetCustomerAJAXResponse.Order();
            order.description = item.description;
            order.id = item.id;
            return order;
        }).collect(Collectors.toList());
        return response;
    }

    public CreateCustomerAJAXResponse create(CreateCustomerAJAXRequest request) {
        BOCreateCustomerRequest boRequest = new BOCreateCustomerRequest();
        boRequest.email = request.email;
        boRequest.firstName = request.firstName;
        boRequest.lastName = request.lastName;

        BOCreateCustomerResponse boResponse = customerWebService.create(boRequest);

        CreateCustomerAJAXResponse response = new CreateCustomerAJAXResponse();
        response.email = boResponse.email;
        response.firstName = boResponse.firstName;
        response.lastName = boResponse.lastName;
        response.id = boResponse.id;
        response.updatedTime = boResponse.updatedTime;
        return response;
    }

    public UpdateCustomerAJAXResponse update(Long id, UpdateCustomerAJAXRequest request) {
        BOUpdateCustomerRequest boRequest = new BOUpdateCustomerRequest();
        boRequest.firstName = request.firstName;
        boRequest.lastName = request.lastName;

        BOUpdateCustomerResponse boResponse = customerWebService.update(id, boRequest);

        UpdateCustomerAJAXResponse response = new UpdateCustomerAJAXResponse();
        response.email = boResponse.email;
        response.firstName = boResponse.firstName;
        response.lastName = boResponse.lastName;
        response.updatedTime = boResponse.updatedTime;
        return response;
    }

    public void delete(Long id) {
        customerWebService.delete(id);
    }

}
