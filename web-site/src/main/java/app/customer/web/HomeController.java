package app.customer.web;

import core.framework.web.Request;
import core.framework.web.Response;

/**
 * @author Else
 */
public class HomeController {
    public Response index(Request request) {
        return Response.html("/index.html", null, null);
    }
}
