package app.customer.web;

import api.BOCustomerAJAXWebService;
import api.customer.BOCreateCustomerAJAXRequest;
import api.customer.BOCreateCustomerAJAXResponse;
import api.customer.BOGetCustomerAJAXResponse;
import api.customer.BOSearchCustomerAJAXRequest;
import api.customer.BOSearchCustomerAJAXResponse;
import api.customer.BOUpdateCustomerAJAXRequest;
import api.customer.BOUpdateCustomerAJAXResponse;
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
