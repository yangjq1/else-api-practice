package app;

import app.api.BOOrderWebService;
import app.api.OrderWebService;
import app.api.order.GetOrderResponse;
import app.order.domain.Order;
import app.order.service.BOOrderService;
import app.order.service.OrderService;
import app.order.web.BOOrderWebServiceImpl;
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
        bind(BOOrderService.class);

        api().service(OrderWebService.class,bind(OrderWebServiceImpl.class));
        api().service(BOOrderWebService.class,bind(BOOrderWebServiceImpl.class));
    }
}
