package app.customer.web;

import core.framework.web.Request;
import core.framework.web.Response;

/**
 * @author Else
 */
public class HomeController {
    public Response index(Request request) {
        Response response = Response.html("/index.html", null, null);
        return response;
    }
}
