package app;

import app.api.BOCustomerAJAXWebService;
import app.customer.domain.Customer;
import app.customer.service.BOCustomerService;
import app.customer.web.BOCustomersAJAXWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Else
 */
public class BOCustomerModule extends Module {
    @Override
    protected void initialize() {
        db().repository(Customer.class);

        bind(BOCustomerService.class);

        api().service(BOCustomerAJAXWebService.class, bind(BOCustomersAJAXWebServiceImpl.class));
    }
}
