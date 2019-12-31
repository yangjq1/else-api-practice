package app.api;

import app.api.order.BOCreateOrderAJAXRequest;
import app.api.order.BOCreateOrderAJAXResponse;
import app.api.order.BOGetOrderAJAXResponse;
import app.api.order.BOSearchOrderAJAXRequest;
import app.api.order.BOSearchOrderAJAXResponse;
import app.api.order.BOUpdateOrderAJAXRequest;
import app.api.order.BOUpdateOrderAJAXResponse;
import core.framework.api.http.HTTPStatus;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
import core.framework.api.web.service.ResponseStatus;

/**
 * @author Else
 */
public interface BOOrderAJAXWebService {
    @GET
    @Path("/bo/order/:id")
    BOGetOrderAJAXResponse get(@PathParam("id") Long id);

    @PUT
    @Path("/bo/order")
    BOSearchOrderAJAXResponse search(BOSearchOrderAJAXRequest request);

    @DELETE
    @Path("/bo/order/:id")
    @ResponseStatus(HTTPStatus.NO_CONTENT)
    void delete(@PathParam("id") Long id);

    @POST
    @Path("/bo/order")
    @ResponseStatus(HTTPStatus.CREATED)
    BOCreateOrderAJAXResponse create(BOCreateOrderAJAXRequest request);

    @PUT
    @Path("/bo/order/:id")
    BOUpdateOrderAJAXResponse update(@PathParam("id") Long id, BOUpdateOrderAJAXRequest request);
}
