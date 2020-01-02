package app.order.service;

import api.BOOrderWebService;
import api.OrderWebService;
import api.order.BOCreateOrderRequest;
import api.order.BOCreateOrderResponse;
import api.order.BOGetOrderResponse;
import api.order.BOSearchOrderRequest;
import api.order.BOSearchOrderResponse;
import api.order.BOUpdateOrderRequest;
import api.order.BOUpdateOrderResponse;
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
public class OrderService {
    @Inject
    BOOrderWebService orderWebService;


    public BOGetOrderResponse get(Long id) {
        BOGetOrderResponse response = orderWebService.get(id);
        return response;
    }

    public BOSearchOrderResponse search(BOSearchOrderRequest request) {
        BOSearchOrderResponse response = orderWebService.search(request);
        return response;
    }

    public void delete(Long id) {
        orderWebService.delete(id);
    }

    public BOCreateOrderResponse create(BOCreateOrderRequest request) {
        BOCreateOrderResponse response = orderWebService.create(request);
        return response;
    }

    public BOUpdateOrderResponse update(Long id, BOUpdateOrderRequest request) {
        BOUpdateOrderResponse response = orderWebService.update(id, request);
        return response;
    }
}
