package app.customer.web;

import api.CustomerAJAXWebService;
import api.customer.BOCreateCustomerRequest;
import api.customer.BOCreateCustomerResponse;
import api.customer.BOGetCustomerResponse;
import api.customer.BOSearchCustomerRequest;
import api.customer.BOSearchCustomerResponse;
import api.customer.BOUpdateCustomerRequest;
import api.customer.BOUpdateCustomerResponse;
import app.customer.service.CustomerService;
import core.framework.inject.Inject;

/**
 * @author Else
 */
public class CustomersAJAXWebServiceImpl implements CustomerAJAXWebService {
    @Inject
    CustomerService customerService;

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
