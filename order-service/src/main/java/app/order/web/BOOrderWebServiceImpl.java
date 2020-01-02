package app.order.web;

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
import app.order.service.BOOrderService;
import app.order.service.OrderService;
import core.framework.inject.Inject;

/**
 * @author Else
 */
public class BOOrderWebServiceImpl implements BOOrderWebService {
    @Inject
    BOOrderService orderService;


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
        return orderService.update(id,request);
    }
}
