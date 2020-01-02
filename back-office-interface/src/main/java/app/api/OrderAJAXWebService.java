package app.api;

import app.api.order.BOCreateOrderRequest;
import app.api.order.BOCreateOrderResponse;
import app.api.order.BOGetOrderResponse;
import app.api.order.BOSearchOrderRequest;
import app.api.order.BOSearchOrderResponse;
import app.api.order.BOUpdateOrderRequest;
import app.api.order.BOUpdateOrderResponse;
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
public interface OrderAJAXWebService {
    @GET
    @Path("/ajax/order/:id")
    BOGetOrderResponse get(@PathParam("id") Long id);

    @PUT
    @Path("/ajax/order")
    BOSearchOrderResponse search(BOSearchOrderRequest request);

    @DELETE
    @Path("/ajax/order/:id")
    @ResponseStatus(HTTPStatus.NO_CONTENT)
    void delete(@PathParam("id") Long id);

    @POST
    @Path("/ajax/order")
    @ResponseStatus(HTTPStatus.CREATED)
    BOCreateOrderResponse create(BOCreateOrderRequest request);

    @PUT
    @Path("/ajax/order/:id")
    BOUpdateOrderResponse update(@PathParam("id") Long id, BOUpdateOrderRequest request);
}
