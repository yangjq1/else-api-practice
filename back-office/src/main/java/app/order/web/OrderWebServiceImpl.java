package app.order.web;

import api.OrderAJAXWebService;
import api.order.BOCreateOrderRequest;
import api.order.BOCreateOrderResponse;
import api.order.BOGetOrderResponse;
import api.order.BOSearchOrderRequest;
import api.order.BOSearchOrderResponse;
import api.order.BOUpdateOrderRequest;
import api.order.BOUpdateOrderResponse;
import app.order.service.OrderService;
import core.framework.inject.Inject;

/**
 * @author Else
 */
public class OrderWebServiceImpl implements OrderAJAXWebService {
    @Inject
    OrderService orderService;


    @Override
    public BOGetOrderResponse get(Long id) {
        return orderService.get(id);
    }

    @Override
    public BOSearchOrderResponse search(BOSearchOrderRequest request) {
        return orderService.search(request);
    }

    @Override
    public void delete(Long id) {
        orderService.delete(id);
    }

    @Override
    public BOCreateOrderResponse create(BOCreateOrderRequest request) {
        return orderService.create(request);
    }

    @Override
    public BOUpdateOrderResponse update(Long id, BOUpdateOrderRequest request) {
        return orderService.update(id, request);
    }


}
