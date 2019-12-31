package app.order.web;

import api.BOOrderAJAXWebService;
import api.order.BOCreateOrderAJAXRequest;
import api.order.BOCreateOrderAJAXResponse;
import api.order.BOGetOrderAJAXResponse;
import api.order.BOSearchOrderAJAXRequest;
import api.order.BOSearchOrderAJAXResponse;
import api.order.BOUpdateOrderAJAXRequest;
import api.order.BOUpdateOrderAJAXResponse;
import app.order.service.BoOrderService;
import core.framework.inject.Inject;

/**
 * @author Else
 */
public class BoOrderWebServiceImpl implements BOOrderAJAXWebService {
    @Inject
    BoOrderService orderService;


    @Override
    public BOGetOrderAJAXResponse get(Long id) {
        return orderService.get(id);
    }

    @Override
    public BOSearchOrderAJAXResponse search(BOSearchOrderAJAXRequest request) {
        return orderService.search(request);
    }

    @Override
    public void delete(Long id) {
        orderService.delete(id);
    }

    @Override
    public BOCreateOrderAJAXResponse create(BOCreateOrderAJAXRequest request) {
        return orderService.create(request);
    }

    @Override
    public BOUpdateOrderAJAXResponse update(Long id, BOUpdateOrderAJAXRequest request) {
        return orderService.update(id, request);
    }


}
