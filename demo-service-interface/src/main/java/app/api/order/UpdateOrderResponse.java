package app.api.order;

import core.framework.api.json.Property;

/**
 * @author Else
 */
public class UpdateOrderResponse {
    @Property(name = "description")
    public String description;
}
