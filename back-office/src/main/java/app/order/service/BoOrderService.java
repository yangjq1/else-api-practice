package app.order.service;

import api.OrderWebService;
import api.order.BOCreateOrderAJAXRequest;
import api.order.BOCreateOrderAJAXResponse;
import api.order.BOGetOrderAJAXResponse;
import api.order.BOSearchOrderAJAXRequest;
import api.order.BOSearchOrderAJAXResponse;
import api.order.BOUpdateOrderAJAXRequest;
import api.order.BOUpdateOrderAJAXResponse;
import api.order.CreateOrderRequest;
import api.order.CreateOrderResponse;
import api.order.GetOrderResponse;
import api.order.SearchOrderRequest;
import api.order.SearchOrderResponse;
import api.order.UpdateOrderRequest;
import api.order.UpdateOrderResponse;
import core.framework.inject.Inject;

import java.util.stream.Collectors;

/**
 * @author Else
 */
public class BoOrderService {
    @Inject
    OrderWebService orderWebService;


    public BOGetOrderAJAXResponse get(Long id) {
        GetOrderResponse getOrderResponse = orderWebService.get(id);
        BOGetOrderAJAXResponse response = new BOGetOrderAJAXResponse();
        response.createdTime = getOrderResponse.createdTime;
        response.description = getOrderResponse.description;
        response.email = getOrderResponse.email;
        response.id = getOrderResponse.id;
        return response;
    }

    public BOSearchOrderAJAXResponse search(BOSearchOrderAJAXRequest request) {
        SearchOrderRequest searchOrderRequest = new SearchOrderRequest();
        searchOrderRequest.customerId = request.customerId;
        SearchOrderResponse searchOrderResponse = orderWebService.search(searchOrderRequest);

        BOSearchOrderAJAXResponse response = new BOSearchOrderAJAXResponse();
        response.orders = searchOrderResponse.orders.stream().map(order -> {
            BOSearchOrderAJAXResponse.Order newOrder = new BOSearchOrderAJAXResponse.Order();
            newOrder.id = order.id;
            newOrder.createdTime = order.createdTime;
            newOrder.description = order.description;
            return newOrder;
        }).collect(Collectors.toList());

        return response;
    }

    public void delete(Long id) {
        orderWebService.delete(id);
    }

    public BOCreateOrderAJAXResponse create(BOCreateOrderAJAXRequest request) {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.customerId = request.customerId;
        createOrderRequest.description = request.description;

        CreateOrderResponse createOrderResponse = orderWebService.create(createOrderRequest);

        BOCreateOrderAJAXResponse response = new BOCreateOrderAJAXResponse();
        response.id = createOrderResponse.id;
        response.createdTime = createOrderResponse.createdTime;
        response.customerId = createOrderResponse.customerId;
        response.description = createOrderResponse.description;
        return response;
    }

    public BOUpdateOrderAJAXResponse update(Long id, BOUpdateOrderAJAXRequest request) {
        UpdateOrderRequest updateOrderRequest = new UpdateOrderRequest();
        updateOrderRequest.description = request.description;

        UpdateOrderResponse updateOrderResponse = orderWebService.update(id, updateOrderRequest);

        BOUpdateOrderAJAXResponse response = new BOUpdateOrderAJAXResponse();
        response.description = updateOrderResponse.description;
        return response;
    }
}
