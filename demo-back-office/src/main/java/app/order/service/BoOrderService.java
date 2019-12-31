package app.order.service;

import app.api.order.BOCreateOrderAJAXRequest;
import app.api.order.BOCreateOrderAJAXResponse;
import app.api.order.BOGetOrderAJAXResponse;
import app.api.order.BOSearchOrderAJAXRequest;
import app.api.order.BOSearchOrderAJAXResponse;
import app.api.order.BOUpdateOrderAJAXRequest;
import app.api.order.BOUpdateOrderAJAXResponse;
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
public class BoOrderService {
    @Inject
    Database database;
    @Inject
    Repository<Order> orderRepository;


    public BOGetOrderAJAXResponse get(Long id) {
        BOGetOrderAJAXResponse response = database.selectOne("select o.id,o.description,o.created_time,c.email from orders as o ,customers as c where c.id = o.customer_id and o.id=?", BOGetOrderAJAXResponse.class, id)
            .orElseThrow(() -> new NotFoundException("order not found, id = " + id));
        return response;
    }

    public BOSearchOrderAJAXResponse search(BOSearchOrderAJAXRequest request) {
        List<Order> orders = orderRepository.select("customer_id = ?", request.customerId);

        BOSearchOrderAJAXResponse response = new BOSearchOrderAJAXResponse();
        response.orders = orders.stream().map(order -> {
            BOSearchOrderAJAXResponse.Order o = new BOSearchOrderAJAXResponse.Order();
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

    public BOCreateOrderAJAXResponse create(BOCreateOrderAJAXRequest request) {
        Order order = new Order();
        order.createdTime = LocalDateTime.now();
        order.customerId = request.customerId;
        order.description = request.description;
        order.id = orderRepository.insert(order).orElseThrow();

        BOCreateOrderAJAXResponse response = new BOCreateOrderAJAXResponse();
        response.id = order.id;
        response.createdTime = order.createdTime;
        response.customerId = order.customerId;
        response.description = order.description;
        return response;
    }

    public BOUpdateOrderAJAXResponse update(Long id, BOUpdateOrderAJAXRequest request) {
        Order order = orderRepository.get(id).orElseThrow(() -> new NotFoundException("order not found,id=" + id));
        order.description = request.description;
        orderRepository.partialUpdate(order);

        BOUpdateOrderAJAXResponse response = new BOUpdateOrderAJAXResponse();
        response.description = order.description;
        return response;
    }
}
