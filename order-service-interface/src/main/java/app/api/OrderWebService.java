package app.api;

import app.api.order.CreateOrderRequest;
import app.api.order.CreateOrderResponse;
import app.api.order.GetOrderResponse;
import app.api.order.SearchOrderRequest;
import app.api.order.SearchOrderResponse;
import app.api.order.UpdateOrderRequest;
import app.api.order.UpdateOrderResponse;
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
public interface OrderWebService {
    @GET
    @Path("/ajax/order/:id")
    GetOrderResponse get(@PathParam("id") Long id);

    @PUT
    @Path("/ajax/order")
    SearchOrderResponse search(SearchOrderRequest request);

    @DELETE
    @Path("/ajax/order/:id")
    void delete(@PathParam("id") Long id);

    @POST
    @Path("/ajax/order")
    @ResponseStatus(HTTPStatus.CREATED)
    CreateOrderResponse create(CreateOrderRequest request);

    @PUT
    @Path("/ajax/order/:id")
    UpdateOrderResponse update(@PathParam("id") Long id, UpdateOrderRequest request);
}
