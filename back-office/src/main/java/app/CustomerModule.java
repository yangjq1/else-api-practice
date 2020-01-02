package app;

import app.api.BOCustomerWebService;
import app.api.CustomerAJAXWebService;
import app.customer.service.CustomerService;
import app.customer.web.CustomersAJAXWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Else
 */
public class CustomerModule extends Module {
    @Override
    protected void initialize() {
        api().client(BOCustomerWebService.class, requiredProperty("app.CustomerService.URL"));
        bind(CustomerService.class);
        api().service(CustomerAJAXWebService.class, bind(CustomersAJAXWebServiceImpl.class));
    }
}
