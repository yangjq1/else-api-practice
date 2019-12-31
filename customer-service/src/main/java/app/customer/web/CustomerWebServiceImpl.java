package app.customer.web;

import api.CustomerWebService;
import api.customer.CreateCustomerRequest;
import api.customer.CreateCustomerResponse;
import api.customer.GetCustomerResponse;
import api.customer.SearchCustomerRequest;
import api.customer.SearchCustomerResponse;
import api.customer.UpdateCustomerRequest;
import api.customer.UpdateCustomerResponse;
import app.customer.service.CustomerService;
import core.framework.inject.Inject;

/**
 * @author Else
 */
public class CustomerWebServiceImpl implements CustomerWebService {
    @Inject
    CustomerService customerService;

    @Override
    public GetCustomerResponse get(Long id) {
        return customerService.get(id);
    }

    @Override
    public SearchCustomerResponse search(SearchCustomerRequest request) {
        return customerService.search(request);
    }

    @Override
    public void delete(Long id) {
        customerService.delete(id);
    }

    @Override
    public CreateCustomerResponse create(CreateCustomerRequest request) {
        return customerService.create(request);
    }

    @Override
    public UpdateCustomerResponse update(Long id, UpdateCustomerRequest request) {
        return customerService.update(id, request);
    }

}
