package api.order;

import core.framework.api.json.Property;
import core.framework.db.Column;

import java.time.LocalDateTime;

/**
 * @author Else
 */
public class BOGetOrderResponse {
    @Column(name = "id")
    @Property(name = "id")
    public Long id;

    @Column(name = "description")
    @Property(name = "description")
    public String description;

    @Column(name = "created_time")
    @Property(name = "created_time")
    public LocalDateTime createdTime;

    @Column(name = "email")
    @Property(name = "email")
    public String email;
}
