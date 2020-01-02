package api;

import api.customer.BOCreateCustomerRequest;
import api.customer.BOCreateCustomerResponse;
import api.customer.BOGetCustomerResponse;
import api.customer.BOSearchCustomerRequest;
import api.customer.BOSearchCustomerResponse;
import api.customer.BOUpdateCustomerRequest;
import api.customer.BOUpdateCustomerResponse;
import api.customer.CreateCustomerRequest;
import api.customer.CreateCustomerResponse;
import api.customer.GetCustomerResponse;
import api.customer.SearchCustomerRequest;
import api.customer.SearchCustomerResponse;
import api.customer.UpdateCustomerRequest;
import api.customer.UpdateCustomerResponse;
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
public interface BOCustomerWebService {

    @GET
    @Path("/bo/customer/:id")
    BOGetCustomerResponse get(@PathParam("id") Long id);

    @PUT
    @Path("/bo/customer")
    BOSearchCustomerResponse search(BOSearchCustomerRequest request);

    @DELETE
    @Path("/bo/customer/:id")
    void delete(@PathParam("id") Long id);

    @POST
    @Path("/bo/customer")
    @ResponseStatus(HTTPStatus.CREATED)
    BOCreateCustomerResponse create(BOCreateCustomerRequest request);

    @PUT
    @Path("/bo/customer/:id")
    BOUpdateCustomerResponse update(@PathParam("id") Long id, BOUpdateCustomerRequest request);
}
