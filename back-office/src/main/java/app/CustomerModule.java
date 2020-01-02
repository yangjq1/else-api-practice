package app;

import api.BOCustomerWebService;
import api.BOOrderWebService;
import api.CustomerAJAXWebService;
import api.CustomerWebService;
import api.OrderAJAXWebService;
import api.OrderWebService;
import app.customer.service.CustomerService;
import app.customer.web.CustomersAJAXWebServiceImpl;
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
