package app.customer.web;

import app.api.CustomerWebService;
import app.api.customer.CreateCustomerRequest;
import app.api.customer.CreateCustomerResponse;
import app.api.customer.GetCustomerResponse;
import app.api.customer.SearchCustomerRequest;
import app.api.customer.SearchCustomerResponse;
import app.api.customer.UpdateCustomerRequest;
import app.api.customer.UpdateCustomerResponse;
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
        return customerService.update(id,request);
    }

}
