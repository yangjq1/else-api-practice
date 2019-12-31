package api.order;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;

/**
 * @author Else
 */
public class UpdateOrderRequest {
    @NotBlank
    @Property(name = "description")
    public String description;
}
