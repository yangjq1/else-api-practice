package app.order.service;

import app.api.order.CreateOrderRequest;
import app.api.order.CreateOrderResponse;
import app.api.order.GetOrderResponse;
import app.api.order.SearchOrderRequest;
import app.api.order.SearchOrderResponse;
import app.api.order.UpdateOrderRequest;
import app.api.order.UpdateOrderResponse;
import app.order.domain.Order;
import core.framework.db.Database;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Else
 */
public class OrderService {
    @Inject
    Database database;
    @Inject
    Repository<Order> orderRepository;


    public GetOrderResponse get(Long id) {
        GetOrderResponse response = database.selectOne("select o.id,o.description,o.created_time,c.email from orders as o ,customers as c where c.id = o.customer_id and o.id=?", GetOrderResponse.class, id)
            .orElseThrow(() -> new NotFoundException("order not found, id = " + id));
        return response;
    }

    public SearchOrderResponse search(SearchOrderRequest request) {
        List<Order> orders = orderRepository.select("customer_id = ?", request.customerId);

        SearchOrderResponse response = new SearchOrderResponse();
        response.orders = orders.stream().map(order -> {
            SearchOrderResponse.Order o = new SearchOrderResponse.Order();
            o.id = order.id;
            o.createdTime = order.createdTime;
            o.description = order.description;
            return o;
        }).collect(Collectors.toList());

        return response;
    }

    public void delete(Long id) {
        orderRepository.delete(id);
    }

    public CreateOrderResponse create(CreateOrderRequest request) {
        Order order = new Order();
        order.createdTime = LocalDateTime.now();
        order.customerId = request.customerId;
        order.description = request.description;
        order.id = orderRepository.insert(order).orElseThrow();

        CreateOrderResponse response = new CreateOrderResponse();
        response.id = order.id;
        response.createdTime = order.createdTime;
        response.customerId = order.customerId;
        response.description = order.description;
        return response;
    }

    public UpdateOrderResponse update(Long id, UpdateOrderRequest request) {
        Order order = orderRepository.get(id).orElseThrow(() -> new NotFoundException("order not found,id=" + id));
        order.description = request.description;
        orderRepository.partialUpdate(order);

        UpdateOrderResponse response = new UpdateOrderResponse();
        response.description = order.description;
        return response;
    }
}
