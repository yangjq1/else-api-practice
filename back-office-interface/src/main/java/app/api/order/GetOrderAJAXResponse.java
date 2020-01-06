package app.api.order;

import core.framework.api.json.Property;

import java.time.LocalDateTime;

/**
 * @author Else
 */
public class GetOrderAJAXResponse {
    @Property(name = "id")
    public Long id;

    @Property(name = "description")
    public String description;

    @Property(name = "created_time")
    public LocalDateTime createdTime;

    @Property(name = "customer_id")
    public Long customerId;
}
