package app.api;

import app.api.order.CreateOrderAJAXRequest;
import app.api.order.CreateOrderAJAXResponse;
import app.api.order.GetOrderAJAXResponse;
import app.api.order.SearchOrderAJAXRequest;
import app.api.order.SearchOrderAJAXResponse;
import app.api.order.UpdateOrderAJAXRequest;
import app.api.order.UpdateOrderAJAXResponse;
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
    GetOrderAJAXResponse get(@PathParam("id") Long id);

    @PUT
    @Path("/ajax/order")
    SearchOrderAJAXResponse search(SearchOrderAJAXRequest request);

    @DELETE
    @Path("/ajax/order/:id")
    @ResponseStatus(HTTPStatus.NO_CONTENT)
    void delete(@PathParam("id") Long id);

    @POST
    @Path("/ajax/order")
    @ResponseStatus(HTTPStatus.CREATED)
    CreateOrderAJAXResponse create(CreateOrderAJAXRequest request);

    @PUT
    @Path("/ajax/order/:id")
    UpdateOrderAJAXResponse update(@PathParam("id") Long id, UpdateOrderAJAXRequest request);
}
