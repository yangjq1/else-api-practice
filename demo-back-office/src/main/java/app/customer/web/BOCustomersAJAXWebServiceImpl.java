package app.customer.web;

import app.api.BOCustomerAJAXWebService;
import app.api.customer.BOCreateCustomerAJAXRequest;
import app.api.customer.BOCreateCustomerAJAXResponse;
import app.api.customer.BOGetCustomerAJAXResponse;
import app.api.customer.BOSearchCustomerAJAXRequest;
import app.api.customer.BOSearchCustomerAJAXResponse;
import app.api.customer.BOUpdateCustomerAJAXRequest;
import app.api.customer.BOUpdateCustomerAJAXResponse;
import app.customer.service.BOCustomerService;
import core.framework.inject.Inject;

/**
 * @author Else
 */
public class BOCustomersAJAXWebServiceImpl implements BOCustomerAJAXWebService {
    @Inject
    BOCustomerService customerService;

    @Override
    public BOGetCustomerAJAXResponse get(Long id) {
        return customerService.get(id);
    }

    @Override
    public BOSearchCustomerAJAXResponse search(BOSearchCustomerAJAXRequest request) {
        return customerService.search(request);
    }

    @Override
    public void delete(Long id) {
        customerService.delete(id);
    }

    @Override
    public BOCreateCustomerAJAXResponse create(BOCreateCustomerAJAXRequest request) {
        return customerService.create(request);
    }

    @Override
    public BOUpdateCustomerAJAXResponse update(Long id, BOUpdateCustomerAJAXRequest request) {
        return customerService.update(id, request);
    }

}
