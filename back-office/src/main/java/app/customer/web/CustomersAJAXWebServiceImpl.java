package app.customer.web;

import app.api.CustomerAJAXWebService;
import app.api.customer.CreateCustomerAJAXResponse;
import app.api.customer.GetCustomerAJAXResponse;
import app.api.customer.UpdateCustomerAJAXResponse;
import app.api.customer.CreateCustomerAJAXRequest;
import app.api.customer.SearchCustomerAJAXRequest;
import app.api.customer.SearchCustomerAJAXResponse;
import app.api.customer.UpdateCustomerAJAXRequest;
import app.customer.service.CustomerService;
import core.framework.inject.Inject;

/**
 * @author Else
 */
public class CustomersAJAXWebServiceImpl implements CustomerAJAXWebService {
    @Inject
    CustomerService customerService;

    @Override
    public GetCustomerAJAXResponse get(Long id) {
        return customerService.get(id);
    }

    @Override
    public SearchCustomerAJAXResponse search(SearchCustomerAJAXRequest request) {
        return customerService.search(request);
    }

    @Override
    public void delete(Long id) {
        customerService.delete(id);
    }

    @Override
    public CreateCustomerAJAXResponse create(CreateCustomerAJAXRequest request) {
        return customerService.create(request);
    }

    @Override
    public UpdateCustomerAJAXResponse update(Long id, UpdateCustomerAJAXRequest request) {
        return customerService.update(id, request);
    }

}
