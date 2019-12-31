package app.api;

import app.api.customer.BOCreateCustomerAJAXRequest;
import app.api.customer.BOCreateCustomerAJAXResponse;
import app.api.customer.BOGetCustomerAJAXResponse;
import app.api.customer.BOSearchCustomerAJAXRequest;
import app.api.customer.BOSearchCustomerAJAXResponse;
import app.api.customer.BOUpdateCustomerAJAXRequest;
import app.api.customer.BOUpdateCustomerAJAXResponse;
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
public interface BOCustomerAJAXWebService {
    @GET
    @Path("/bo/customer/:id")
    BOGetCustomerAJAXResponse get(@PathParam("id") Long id);

    @PUT
    @Path("/bo/customer")
    BOSearchCustomerAJAXResponse search(BOSearchCustomerAJAXRequest request);

    @DELETE
    @Path("/bo/customer/:id")
    @ResponseStatus(HTTPStatus.NO_CONTENT)
    void delete(@PathParam("id") Long id);

    @POST
    @Path("/bo/customer")
    @ResponseStatus(HTTPStatus.CREATED)
    BOCreateCustomerAJAXResponse create(BOCreateCustomerAJAXRequest request);

    @PUT
    @Path("/bo/customer/:id")
    BOUpdateCustomerAJAXResponse update(@PathParam("id") Long id, BOUpdateCustomerAJAXRequest request);
}
