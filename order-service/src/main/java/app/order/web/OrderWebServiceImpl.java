package app.order.web;

import app.api.OrderWebService;
import app.api.order.CreateOrderRequest;
import app.api.order.CreateOrderResponse;
import app.api.order.GetOrderResponse;
import app.api.order.SearchOrderRequest;
import app.api.order.SearchOrderResponse;
import app.api.order.UpdateOrderRequest;
import app.api.order.UpdateOrderResponse;
import app.order.service.OrderService;
import core.framework.inject.Inject;

/**
 * @author Else
 */
public class OrderWebServiceImpl implements OrderWebService {
    @Inject
    OrderService orderService;


    @Override
    public GetOrderResponse get(Long id) {
        return orderService.get(id);
    }

    @Override
    public SearchOrderResponse search(SearchOrderRequest request) {
        return orderService.search(request);
    }

    @Override
    public void delete(Long id) {
        orderService.delete(id);
    }

    @Override
    public CreateOrderResponse create(CreateOrderRequest request) {
        return orderService.create(request);
    }

    @Override
    public UpdateOrderResponse update(Long id, UpdateOrderRequest request) {
        return orderService.update(id, request);
    }
}
