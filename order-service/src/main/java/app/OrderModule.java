package app;

import api.OrderWebService;
import api.order.GetOrderResponse;
import app.order.domain.Order;
import app.order.service.OrderService;
import app.order.web.OrderWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Else
 */
public class OrderModule extends Module {
    @Override
    protected void initialize() {


        db().view(GetOrderResponse.class);
        db().repository(Order.class);

        bind(OrderService.class);

        api().service(OrderWebService.class,bind(OrderWebServiceImpl.class));
        api().client(OrderWebService.class, requiredProperty("app.OrderWebService.URL"));
    }
}
