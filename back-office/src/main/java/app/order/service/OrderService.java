package app.order.service;

import app.api.BOOrderWebService;
import app.api.order.BOCreateOrderRequest;
import app.api.order.BOCreateOrderResponse;
import app.api.order.BOGetOrderResponse;
import app.api.order.BOSearchOrderRequest;
import app.api.order.BOSearchOrderResponse;
import app.api.order.BOUpdateOrderRequest;
import app.api.order.BOUpdateOrderResponse;
import core.framework.inject.Inject;

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
