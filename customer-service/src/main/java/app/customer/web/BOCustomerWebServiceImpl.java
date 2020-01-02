package app.customer.web;

import app.api.BOCustomerWebService;
import app.api.customer.BOCreateCustomerRequest;
import app.api.customer.BOCreateCustomerResponse;
import app.api.customer.BOGetCustomerResponse;
import app.api.customer.BOSearchCustomerRequest;
import app.api.customer.BOSearchCustomerResponse;
import app.api.customer.BOUpdateCustomerRequest;
import app.api.customer.BOUpdateCustomerResponse;
import app.customer.service.BOCustomerService;
import core.framework.inject.Inject;

/**
 * @author Else
 */
public class BOCustomerWebServiceImpl implements BOCustomerWebService {
    @Inject
    BOCustomerService customerService;


    @Override
    public BOGetCustomerResponse get(Long id) {
        return customerService.get(id);
    }

    @Override
    public BOSearchCustomerResponse search(BOSearchCustomerRequest request) {
        return customerService.search(request);
    }

    @Override
    public void delete(Long id) {
        customerService.delete(id);
    }

    @Override
    public BOCreateCustomerResponse create(BOCreateCustomerRequest request) {
        return customerService.create(request);
    }

    @Override
    public BOUpdateCustomerResponse update(Long id, BOUpdateCustomerRequest request) {
        return customerService.update(id, request);
    }
}
