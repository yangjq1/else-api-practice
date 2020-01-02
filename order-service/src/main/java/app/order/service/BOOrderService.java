package app.order.service;

import api.order.BOCreateOrderRequest;
import api.order.BOCreateOrderResponse;
import api.order.BOGetOrderResponse;
import api.order.BOSearchOrderRequest;
import api.order.BOSearchOrderResponse;
import api.order.BOUpdateOrderRequest;
import api.order.BOUpdateOrderResponse;
import api.order.CreateOrderRequest;
import api.order.CreateOrderResponse;
import api.order.GetOrderResponse;
import api.order.SearchOrderRequest;
import api.order.SearchOrderResponse;
import api.order.UpdateOrderRequest;
import api.order.UpdateOrderResponse;
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
public class BOOrderService {
    @Inject
    Database database;
    @Inject
    Repository<Order> orderRepository;


    public BOGetOrderResponse get(Long id) {
        BOGetOrderResponse response = database.selectOne("select o.id,o.description,o.created_time,c.email from orders as o ,customers as c where c.id = o.customer_id and o.id=?", BOGetOrderResponse.class, id)
            .orElseThrow(() -> new NotFoundException("order not found, id = " + id));
        return response;
    }

    public BOSearchOrderResponse search(BOSearchOrderRequest request) {
        List<Order> orders = orderRepository.select("customer_id = ?", request.customerId);

        BOSearchOrderResponse response = new BOSearchOrderResponse();
        response.orders = orders.stream().map(order->{
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
