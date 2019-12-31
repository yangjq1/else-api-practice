package app.customer.service;

import api.CustomerWebService;
import api.OrderWebService;
import api.customer.BOCreateCustomerAJAXRequest;
import api.customer.BOCreateCustomerAJAXResponse;
import api.customer.BOGetCustomerAJAXResponse;
import api.customer.BOSearchCustomerAJAXRequest;
import api.customer.BOSearchCustomerAJAXResponse;
import api.customer.BOUpdateCustomerAJAXRequest;
import api.customer.BOUpdateCustomerAJAXResponse;
import api.customer.CreateCustomerRequest;
import api.customer.CreateCustomerResponse;
import api.customer.GetCustomerResponse;
import api.customer.SearchCustomerRequest;
import api.customer.SearchCustomerResponse;
import api.customer.UpdateCustomerRequest;
import api.customer.UpdateCustomerResponse;
import api.order.SearchOrderRequest;
import core.framework.inject.Inject;

import java.util.stream.Collectors;

/**
 * @author Else
 */
public class BOCustomerService {
    @Inject
    OrderWebService orderWebService;
    @Inject
    CustomerWebService customerWebService;

    public BOSearchCustomerAJAXResponse search(BOSearchCustomerAJAXRequest request) {
        SearchCustomerRequest searchCustomerRequest = new SearchCustomerRequest();
        searchCustomerRequest.email = request.email;
        searchCustomerRequest.firstName = request.firstName;
        searchCustomerRequest.lastName = request.lastName;
        searchCustomerRequest.limit = request.limit;
        searchCustomerRequest.skip = request.skip;

        SearchCustomerResponse searchCustomerResponse = customerWebService.search(searchCustomerRequest);

        BOSearchCustomerAJAXResponse response = new BOSearchCustomerAJAXResponse();
        response.customers = searchCustomerResponse.customers.stream().map(item -> {
            BOSearchCustomerAJAXResponse.Customer newCustomer = new BOSearchCustomerAJAXResponse.Customer();
            newCustomer.email = item.email;
            newCustomer.firstName = item.firstName;
            newCustomer.lastName = item.lastName;
            newCustomer.id = item.id;
            newCustomer.updatedTime = item.updatedTime;
            return newCustomer;
        }).collect(Collectors.toList());
        response.total = searchCustomerResponse.total;

        return response;
    }


    public BOGetCustomerAJAXResponse get(Long id) {
        GetCustomerResponse getCustomerResponse = customerWebService.get(id);

        BOGetCustomerAJAXResponse response = new BOGetCustomerAJAXResponse();
        response.email = getCustomerResponse.email;
        response.firstName = getCustomerResponse.firstName;
        response.lastName = getCustomerResponse.lastName;
        response.id = getCustomerResponse.id;
        response.updatedTime = getCustomerResponse.updatedTime;

        SearchOrderRequest request = new SearchOrderRequest();
        request.customerId = id;
        response.orders = orderWebService.search(request).orders.stream().map(item -> {
            BOGetCustomerAJAXResponse.Order newOrder = new BOGetCustomerAJAXResponse.Order();
            newOrder.description = item.description;
            newOrder.id = item.id;
            return newOrder;
        }).collect(Collectors.toList());

        return response;
    }

    public BOCreateCustomerAJAXResponse create(BOCreateCustomerAJAXRequest request) {
        CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
        createCustomerRequest.email = request.email;
        createCustomerRequest.firstName = request.firstName;
        createCustomerRequest.lastName = request.lastName;

        CreateCustomerResponse createCustomerResponse = customerWebService.create(createCustomerRequest);

        BOCreateCustomerAJAXResponse response = new BOCreateCustomerAJAXResponse();
        response.id = createCustomerResponse.id;
        response.email = createCustomerResponse.email;
        response.firstName = createCustomerResponse.firstName;
        response.lastName = createCustomerResponse.lastName;
        response.updatedTime = createCustomerResponse.updatedTime;
        return response;
    }

    public BOUpdateCustomerAJAXResponse update(Long id, BOUpdateCustomerAJAXRequest request) {
        UpdateCustomerRequest updateCustomerRequest = new UpdateCustomerRequest();
        updateCustomerRequest.lastName = request.lastName;
        updateCustomerRequest.firstName = request.firstName;

        UpdateCustomerResponse updateCustomerResponse = customerWebService.update(id, updateCustomerRequest);

        BOUpdateCustomerAJAXResponse response = new BOUpdateCustomerAJAXResponse();
        response.email = updateCustomerResponse.email;
        response.firstName = updateCustomerResponse.firstName;
        response.lastName = updateCustomerResponse.lastName;
        response.updatedTime = updateCustomerResponse.updatedTime;
        return response;
    }

    public void delete(Long id) {
        customerWebService.delete(id);
    }

}
