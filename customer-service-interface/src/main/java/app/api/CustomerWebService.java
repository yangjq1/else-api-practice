package app.api;

import app.api.customer.CreateCustomerRequest;
import app.api.customer.CreateCustomerResponse;
import app.api.customer.GetCustomerResponse;
import app.api.customer.SearchCustomerRequest;
import app.api.customer.SearchCustomerResponse;
import app.api.customer.UpdateCustomerRequest;
import app.api.customer.UpdateCustomerResponse;
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
public interface CustomerWebService {

    @GET
    @Path("/customer/:id")
    GetCustomerResponse get(@PathParam("id") Long id);

    @PUT
    @Path("/customer")
    SearchCustomerResponse search(SearchCustomerRequest request);

    @DELETE
    @Path("/customer/:id")
    void delete(@PathParam("id") Long id);

    @POST
    @Path("/customer")
    @ResponseStatus(HTTPStatus.CREATED)
    CreateCustomerResponse create(CreateCustomerRequest request);

    @PUT
    @Path("/customer/:id")
    UpdateCustomerResponse update(@PathParam("id") Long id, UpdateCustomerRequest request);
}
