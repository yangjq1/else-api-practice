package api;

import api.customer.BOCreateCustomerRequest;
import api.customer.BOCreateCustomerResponse;
import api.customer.BOGetCustomerResponse;
import api.customer.BOSearchCustomerRequest;
import api.customer.BOSearchCustomerResponse;
import api.customer.BOUpdateCustomerRequest;
import api.customer.BOUpdateCustomerResponse;
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
public interface CustomerAJAXWebService {
    @GET
    @Path("/ajax/customer/:id")
    BOGetCustomerResponse get(@PathParam("id") Long id);

    @PUT
    @Path("/ajax/customer")
    BOSearchCustomerResponse search(BOSearchCustomerRequest request);

    @DELETE
    @Path("/ajax/customer/:id")
    @ResponseStatus(HTTPStatus.NO_CONTENT)
    void delete(@PathParam("id") Long id);

    @POST
    @Path("/ajax/customer")
    @ResponseStatus(HTTPStatus.CREATED)
    BOCreateCustomerResponse create(BOCreateCustomerRequest request);

    @PUT
    @Path("/ajax/customer/:id")
    BOUpdateCustomerResponse update(@PathParam("id") Long id, BOUpdateCustomerRequest request);
}
