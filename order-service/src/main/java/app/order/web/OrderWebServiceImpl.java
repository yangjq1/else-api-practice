package app.order.web;

import api.OrderWebService;
import api.order.CreateOrderRequest;
import api.order.CreateOrderResponse;
import api.order.GetOrderResponse;
import api.order.SearchOrderRequest;
import api.order.SearchOrderResponse;
import api.order.UpdateOrderRequest;
import api.order.UpdateOrderResponse;
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
        return orderService.update(id,request);
    }
}
