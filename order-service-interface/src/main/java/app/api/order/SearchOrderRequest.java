package app.api.order;

import core.framework.api.json.Property;

/**
 * @author Else
 */
public class SearchOrderRequest {
    @Property(name = "customer_id")
    public Long customerId;
}
