package app;

import api.BOOrderWebService;
import api.OrderAJAXWebService;
import app.order.service.OrderService;
import app.order.web.OrderWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Else
 */
public class OrderModule extends Module {
    @Override
    protected void initialize() {
        api().client(BOOrderWebService.class, requiredProperty("app.BOOrderService.URL"));

        bind(OrderService.class);

        api().service(OrderAJAXWebService.class, bind(OrderWebServiceImpl.class));

    }
}
