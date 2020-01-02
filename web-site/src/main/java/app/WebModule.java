package app;

import app.customer.web.HomeController;
import core.framework.module.Module;

import static core.framework.http.HTTPMethod.GET;

/**
 * @author Else
 */
public class WebModule extends Module {
    @Override
    protected void initialize() {
        HomeController index = bind(HomeController.class);
        http().route(GET, "/", index::index);
    }
}
