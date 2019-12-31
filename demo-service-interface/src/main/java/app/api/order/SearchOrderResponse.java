package app.api.order;

import core.framework.api.json.Property;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Else
 */
public class SearchOrderResponse {
    @Property(name = "orders")
    public List<Order> orders;

    public static class Order{
        @Property(name = "id")
        public Long id;

        @Property(name = "description")
        public String description;

        @Property(name = "created_time")
        public LocalDateTime createdTime;
    }
}
