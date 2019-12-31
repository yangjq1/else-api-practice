package app;

import app.api.BOOrderAJAXWebService;
import app.api.order.BOGetOrderAJAXResponse;
import app.order.domain.Order;
import app.order.service.BoOrderService;
import app.order.web.BoOrderWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Else
 */
public class BOOrderModule extends Module {
    @Override
    protected void initialize() {
        loadProperties("app.properties");

        db().view(BOGetOrderAJAXResponse.class);
        db().repository(Order.class);

        bind(BoOrderService.class);

        api().service(BOOrderAJAXWebService.class, bind(BoOrderWebServiceImpl.class));
        api().client(BOOrderAJAXWebService.class, requiredProperty("app.OrderWebService.URL"));
    }
}
