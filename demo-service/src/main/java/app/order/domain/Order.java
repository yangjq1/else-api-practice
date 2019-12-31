package app.order.domain;

import core.framework.api.validate.NotNull;
import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;

import java.time.LocalDateTime;

/**
 * @author Else
 */
@Table(name = "orders")
public class Order {
    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    public Long id;

    @NotNull
    @Column(name = "customer_id")
    public Long customerId;

    @Column(name = "description")
    public String description;

    @NotNull
    @Column(name = "created_time")
    public LocalDateTime createdTime;
}
