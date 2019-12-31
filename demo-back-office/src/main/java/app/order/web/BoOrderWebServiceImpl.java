package app.order.web;

import app.api.BOOrderAJAXWebService;
import app.api.order.BOCreateOrderAJAXRequest;
import app.api.order.BOCreateOrderAJAXResponse;
import app.api.order.BOGetOrderAJAXResponse;
import app.api.order.BOSearchOrderAJAXRequest;
import app.api.order.BOSearchOrderAJAXResponse;
import app.api.order.BOUpdateOrderAJAXRequest;
import app.api.order.BOUpdateOrderAJAXResponse;
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
