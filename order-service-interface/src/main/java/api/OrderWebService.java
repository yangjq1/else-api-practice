package api;

import api.order.CreateOrderRequest;
import api.order.CreateOrderResponse;
import api.order.GetOrderResponse;
import api.order.SearchOrderRequest;
import api.order.SearchOrderResponse;
import api.order.UpdateOrderRequest;
import api.order.UpdateOrderResponse;
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
