package app.order.web;

import app.api.BOOrderWebService;
import app.api.order.BOCreateOrderRequest;
import app.api.order.BOCreateOrderResponse;
import app.api.order.BOGetOrderResponse;
import app.api.order.BOSearchOrderRequest;
import app.api.order.BOSearchOrderResponse;
import app.api.order.BOUpdateOrderRequest;
import app.api.order.BOUpdateOrderResponse;
import app.order.service.BOOrderService;
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
        return orderService.update(id, request);
    }
}
