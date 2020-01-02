package api.customer;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Else
 */
public class BOGetCustomerResponse {
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
    public List<Order> orders;

    public static class Order {
        @Property(name = "id")
        public Long id;

        @Property(name = "description")
        public String description;

    }
}
