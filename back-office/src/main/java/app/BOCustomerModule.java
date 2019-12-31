package app;

import api.BOCustomerAJAXWebService;
import api.CustomerWebService;
import app.customer.service.BOCustomerService;
import app.customer.web.BOCustomersAJAXWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Else
 */
public class BOCustomerModule extends Module {
    @Override
    protected void initialize() {
        api().client(CustomerWebService.class, requiredProperty("app.CustomerWebService.URL"));
        bind(BOCustomerService.class);
        api().service(BOCustomerAJAXWebService.class, bind(BOCustomersAJAXWebServiceImpl.class));
    }
}
