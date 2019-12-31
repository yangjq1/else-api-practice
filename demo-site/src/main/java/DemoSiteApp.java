import app.WebModule;
import core.framework.module.App;
import core.framework.module.SystemModule;

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
