package app;

import api.BOCustomerWebService;
import api.BOOrderWebService;
import api.CustomerWebService;
import api.OrderWebService;
import app.customer.domain.Customer;
import app.customer.service.BOCustomerService;
import app.customer.service.CustomerService;
import app.customer.web.BOCustomerWebServiceImpl;
import app.customer.web.CustomerWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Else
 */
public class CustomerModule extends Module {
    @Override
    protected void initialize() {
        db().repository(Customer.class);
        api().client(OrderWebService.class, requiredProperty("app.OrderService.URL"));
        api().client(BOOrderWebService.class, requiredProperty("app.BOOrderService.URL"));

        bind(CustomerService.class);
        bind(BOCustomerService.class);

        api().service(CustomerWebService.class, bind(CustomerWebServiceImpl.class));
        api().service(BOCustomerWebService.class, bind(BOCustomerWebServiceImpl.class));

    }
}
