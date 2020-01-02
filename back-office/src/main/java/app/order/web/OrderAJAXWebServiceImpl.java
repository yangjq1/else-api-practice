package app.order.web;

import app.api.OrderAJAXWebService;
import app.api.order.CreateOrderAJAXRequest;
import app.api.order.CreateOrderAJAXResponse;
import app.api.order.GetOrderAJAXResponse;
import app.api.order.SearchOrderAJAXRequest;
import app.api.order.SearchOrderAJAXResponse;
import app.api.order.UpdateOrderAJAXRequest;
import app.api.order.UpdateOrderAJAXResponse;
import app.order.service.OrderService;
import core.framework.inject.Inject;

/**
 * @author Else
 */
public class OrderAJAXWebServiceImpl implements OrderAJAXWebService {
    @Inject
    OrderService orderService;


    @Override
    public GetOrderAJAXResponse get(Long id) {
        return orderService.get(id);
    }

    @Override
    public SearchOrderAJAXResponse search(SearchOrderAJAXRequest request) {
        return orderService.search(request);
    }

    @Override
    public void delete(Long id) {
        orderService.delete(id);
    }

    @Override
    public CreateOrderAJAXResponse create(CreateOrderAJAXRequest request) {
        return orderService.create(request);
    }

    @Override
    public UpdateOrderAJAXResponse update(Long id, UpdateOrderAJAXRequest request) {
        return orderService.update(id, request);
    }


}
