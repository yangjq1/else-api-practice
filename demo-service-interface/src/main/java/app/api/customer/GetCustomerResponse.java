package app.api.customer;

import app.api.order.SearchOrderResponse;
import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Else
 */
public class GetCustomerResponse {
    @NotNull
    @Property(name = "id")
    public Long id;

    @NotNull
    @NotBlank
    @Property(name = "email")
    public String email;

    @NotNull
    @NotBlank
    @Property(name = "first_name")
    public String firstName;

    @NotBlank
    @Property(name = "last_name")
    public String lastName;

    @NotNull
    @Property(name = "updated_time")
    public LocalDateTime updatedTime;

    @Property(name = "orders")
    public List<SearchOrderResponse.Order> orders;

}
