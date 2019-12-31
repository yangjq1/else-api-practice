package app.api.customer;

import core.framework.api.json.Property;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Else
 */
public class SearchCustomerResponse {
    @Property(name = "total")
    public Integer total;

    @Property(name = "customers")
    public List<Customer> customers;

    public static class Customer{
        @Property(name = "id")
        public Long id;

        @Property(name = "email")
        public String email;

        @Property(name = "first_name")
        public String firstName;

        @Property(name = "last_name")
        public String lastName;

        @Property(name = "updated_time")
        public LocalDateTime updatedTime;
    }
}
