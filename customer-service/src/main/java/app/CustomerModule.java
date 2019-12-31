package app;

import api.CustomerWebService;
import api.OrderWebService;
import app.customer.domain.Customer;
import app.customer.service.CustomerService;
import app.customer.web.CustomerWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Else
 */
public class CustomerModule extends Module {
    @Override
    protected void initialize() {


        db().repository(Customer.class);
        api().client(OrderWebService.class, requiredProperty("app.OrderWebService.URL"));
        bind(CustomerService.class);

        api().service(CustomerWebService.class, bind(CustomerWebServiceImpl.class));

    }
}
