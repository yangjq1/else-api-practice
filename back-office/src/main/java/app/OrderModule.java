package app;

import app.api.BOOrderWebService;
import app.api.OrderAJAXWebService;
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
