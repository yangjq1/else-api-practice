package api.order;

import core.framework.api.json.Property;
import core.framework.api.web.service.QueryParam;

/**
 * @author Else
 */
public class SearchOrderRequest {
    @QueryParam(name = "customer_id")
    @Property(name = "customer_id")
    public Long customerId;
}
