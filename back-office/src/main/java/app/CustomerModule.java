package app;

import app.api.BOCustomerWebService;
import app.api.CustomerAJAXWebService;
import app.api.OrderAJAXWebService;
import app.service.CustomerService;
import app.web.CustomersAJAXWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Else
 */
public class CustomerModule extends Module {
    @Override
    protected void initialize() {
        api().client(BOCustomerWebService.class, requiredProperty("app.BOCustomerService.URL"));
        api().client(OrderAJAXWebService.class, requiredProperty("app.OrderAJAXService.URL"));
        bind(CustomerService.class);
        api().service(CustomerAJAXWebService.class, bind(CustomersAJAXWebServiceImpl.class));
    }
}
