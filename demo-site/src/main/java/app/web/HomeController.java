package app.web;

import core.framework.web.Request;
import core.framework.web.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Else
 */
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    public Response index(Request request){
        Response response = Response.html("/index.html", null, null);
        return response;
    }

}
