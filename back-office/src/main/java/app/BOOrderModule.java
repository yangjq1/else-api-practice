package app;

import api.BOOrderAJAXWebService;
import api.OrderWebService;
import api.order.BOGetOrderAJAXResponse;
import app.order.service.BoOrderService;
import app.order.web.BoOrderWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Else
 */
public class BOOrderModule extends Module {
    @Override
    protected void initialize() {

        db().view(BOGetOrderAJAXResponse.class);

        api().client(BOOrderAJAXWebService.class, requiredProperty("app.BOOrderAJAXWebService.URL"));
        api().client(OrderWebService.class, requiredProperty("app.OrderWebService.URL"));

        bind(BoOrderService.class);

        api().service(BOOrderAJAXWebService.class, bind(BoOrderWebServiceImpl.class));

    }
}
