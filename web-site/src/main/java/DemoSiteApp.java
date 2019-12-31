import app.WebModule;
import core.framework.module.App;

/**
 * @author neo
 */
public class DemoSiteApp extends App {
    @Override
    protected void initialize() {
        http().httpsPort(8443);
        load(new WebModule());
    }
}
