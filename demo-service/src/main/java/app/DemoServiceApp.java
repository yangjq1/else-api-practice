package app;

import app.customer.domain.Customer;
import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author Else
 */
public class DemoServiceApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new OrderModule());
        load(new CustomerModule());

    }
}
