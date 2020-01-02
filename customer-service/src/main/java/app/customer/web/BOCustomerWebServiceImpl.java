package app.customer.web;

import api.BOCustomerWebService;
import api.CustomerWebService;
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
import app.customer.service.BOCustomerService;
import app.customer.service.CustomerService;
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
