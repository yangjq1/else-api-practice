package app;

import app.api.BOCustomerWebService;
import app.api.BOOrderWebService;
import app.api.CustomerWebService;
import app.api.OrderWebService;
import app.domain.Customer;
import app.service.BOCustomerService;
import app.service.CustomerService;
import app.web.BOCustomerWebServiceImpl;
import app.web.CustomerWebServiceImpl;
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
