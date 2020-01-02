package app.api;

import app.api.customer.CreateCustomerAJAXRequest;
import app.api.customer.CreateCustomerAJAXResponse;
import app.api.customer.GetCustomerAJAXResponse;
import app.api.customer.SearchCustomerAJAXRequest;
import app.api.customer.SearchCustomerAJAXResponse;
import app.api.customer.UpdateCustomerAJAXRequest;
import app.api.customer.UpdateCustomerAJAXResponse;
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
    GetCustomerAJAXResponse get(@PathParam("id") Long id);

    @PUT
    @Path("/ajax/customer")
    SearchCustomerAJAXResponse search(SearchCustomerAJAXRequest request);

    @DELETE
    @Path("/ajax/customer/:id")
    @ResponseStatus(HTTPStatus.NO_CONTENT)
    void delete(@PathParam("id") Long id);

    @POST
    @Path("/ajax/customer")
    @ResponseStatus(HTTPStatus.CREATED)
    CreateCustomerAJAXResponse create(CreateCustomerAJAXRequest request);

    @PUT
    @Path("/ajax/customer/:id")
    UpdateCustomerAJAXResponse update(@PathParam("id") Long id, UpdateCustomerAJAXRequest request);
}
