package app.customer.service;

import api.BOCustomerWebService;
import api.OrderAJAXWebService;
import api.OrderWebService;
import api.customer.BOCreateCustomerRequest;
import api.customer.BOCreateCustomerResponse;
import api.customer.BOGetCustomerResponse;
import api.customer.BOSearchCustomerRequest;
import api.customer.BOSearchCustomerResponse;
import api.customer.BOUpdateCustomerRequest;
import api.customer.BOUpdateCustomerResponse;
import api.order.BOSearchOrderRequest;
import core.framework.inject.Inject;

import java.util.stream.Collectors;

/**
 * @author Else
 */
public class CustomerService {
    @Inject
    OrderAJAXWebService orderWebService;
    @Inject
    BOCustomerWebService customerWebService;

    public BOSearchCustomerResponse search(BOSearchCustomerRequest request) {
        BOSearchCustomerResponse response = customerWebService.search(request);
        return response;
    }


    public BOGetCustomerResponse get(Long id) {
        BOGetCustomerResponse response = customerWebService.get(id);

        BOSearchOrderRequest request = new BOSearchOrderRequest();
        request.customerId = id;
        response.orders = orderWebService.search(request).orders.stream().map(item -> {
            BOGetCustomerResponse.Order newOrder = new BOGetCustomerResponse.Order();
            newOrder.description = item.description;
            newOrder.id = item.id;
            return newOrder;
        }).collect(Collectors.toList());

        return response;
    }

    public BOCreateCustomerResponse create(BOCreateCustomerRequest request) {
        BOCreateCustomerResponse response = customerWebService.create(request);
        return response;
    }

    public BOUpdateCustomerResponse update(Long id, BOUpdateCustomerRequest request) {
        BOUpdateCustomerResponse response = customerWebService.update(id, request);
        return response;
    }

    public void delete(Long id) {
        customerWebService.delete(id);
    }

}
