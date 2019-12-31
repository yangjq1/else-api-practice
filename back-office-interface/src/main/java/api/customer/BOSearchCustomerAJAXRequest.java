package api.customer;

import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;

/**
 * @author Else
 */
public class BOSearchCustomerAJAXRequest {
    @NotNull
    @Property(name = "skip")
    public Integer skip = 0;

    @NotNull
    @Property(name = "limit")
    public Integer limit = 1000;

    @Property(name = "email")
    public String email;

    @Property(name = "first_name")
    public String firstName;

    @Property(name = "last_name")
    public String lastName;
}
