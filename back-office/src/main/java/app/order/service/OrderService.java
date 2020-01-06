package app.order.service;

import app.api.BOOrderWebService;
import app.api.order.BOCreateOrderRequest;
import app.api.order.BOCreateOrderResponse;
import app.api.order.BOGetOrderResponse;
import app.api.order.BOSearchOrderRequest;
import app.api.order.BOSearchOrderResponse;
import app.api.order.BOUpdateOrderRequest;
import app.api.order.BOUpdateOrderResponse;
import app.api.order.CreateOrderAJAXRequest;
import app.api.order.CreateOrderAJAXResponse;
import app.api.order.GetOrderAJAXResponse;
import app.api.order.SearchOrderAJAXRequest;
import app.api.order.SearchOrderAJAXResponse;
import app.api.order.UpdateOrderAJAXRequest;
import app.api.order.UpdateOrderAJAXResponse;
import core.framework.inject.Inject;

import java.util.stream.Collectors;

/**
 * @author Else
 */
public class OrderService {
    @Inject
    BOOrderWebService orderWebService;


    public GetOrderAJAXResponse get(Long id) {
        BOGetOrderResponse boResponse = orderWebService.get(id);

        GetOrderAJAXResponse response = new GetOrderAJAXResponse();
        response.createdTime = boResponse.createdTime;
        response.description = boResponse.description;
        response.id = boResponse.id;
        response.customerId = boResponse.customerId;
        return response;
    }


    public SearchOrderAJAXResponse search(SearchOrderAJAXRequest request) {
        BOSearchOrderRequest boRequest = new BOSearchOrderRequest();
        boRequest.customerId = request.customerId;

        BOSearchOrderResponse boResponse = orderWebService.search(boRequest);

        SearchOrderAJAXResponse response = new SearchOrderAJAXResponse();
        response.orders = boResponse.orders.stream().map(item -> {
            SearchOrderAJAXResponse.Order order = new SearchOrderAJAXResponse.Order();
            order.createdTime = item.createdTime;
            order.description = item.description;
            order.id = item.id;
            return order;
        }).collect(Collectors.toList());
        return response;
    }

    public void delete(Long id) {
        orderWebService.delete(id);
    }

    public CreateOrderAJAXResponse create(CreateOrderAJAXRequest request) {
        BOCreateOrderRequest boRequest = new BOCreateOrderRequest();
        boRequest.customerId = request.customerId;
        boRequest.description = request.description;

        BOCreateOrderResponse boResponse = orderWebService.create(boRequest);

        CreateOrderAJAXResponse response = new CreateOrderAJAXResponse();
        response.createdTime = boResponse.createdTime;
        response.customerId = boResponse.customerId;
        response.description = boResponse.description;
        response.id = boResponse.id;
        return response;
    }

    public UpdateOrderAJAXResponse update(Long id, UpdateOrderAJAXRequest request) {
        BOUpdateOrderRequest boRequest = new BOUpdateOrderRequest();
        boRequest.description = request.description;

        BOUpdateOrderResponse boResponse = orderWebService.update(id, boRequest);

        UpdateOrderAJAXResponse response = new UpdateOrderAJAXResponse();
        response.description = boResponse.description;
        return response;
    }
}
