package app.order.service;

import app.api.order.BOCreateOrderRequest;
import app.api.order.BOCreateOrderResponse;
import app.api.order.BOGetOrderResponse;
import app.api.order.BOSearchOrderRequest;
import app.api.order.BOSearchOrderResponse;
import app.api.order.BOUpdateOrderRequest;
import app.api.order.BOUpdateOrderResponse;
import app.order.domain.Order;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Else
 */
public class BOOrderService {
    @Inject
    Repository<Order> orderRepository;


    public BOGetOrderResponse get(Long id) {
        Order order = orderRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found,id=" + id));
        BOGetOrderResponse response = new BOGetOrderResponse();
        response.createdTime = order.createdTime;
        response.description = order.description;
        response.customerId = order.customerId;
        return response;
    }

    public BOSearchOrderResponse search(BOSearchOrderRequest request) {
        List<Order> orders = orderRepository.select("customer_id = ?", request.customerId);

        BOSearchOrderResponse response = new BOSearchOrderResponse();
        response.orders = orders.stream().map(order -> {
            BOSearchOrderResponse.Order o = new BOSearchOrderResponse.Order();
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

    public BOCreateOrderResponse create(BOCreateOrderRequest request) {
        Order order = new Order();
        order.createdTime = LocalDateTime.now();
        order.customerId = request.customerId;
        order.description = request.description;
        order.id = orderRepository.insert(order).orElseThrow();

        BOCreateOrderResponse response = new BOCreateOrderResponse();
        response.id = order.id;
        response.createdTime = order.createdTime;
        response.customerId = order.customerId;
        response.description = order.description;
        return response;
    }

    public BOUpdateOrderResponse update(Long id, BOUpdateOrderRequest request) {
        Order order = orderRepository.get(id).orElseThrow(() -> new NotFoundException("order not found,id=" + id));
        order.description = request.description;
        orderRepository.partialUpdate(order);

        BOUpdateOrderResponse response = new BOUpdateOrderResponse();
        response.description = order.description;
        return response;
    }
}
