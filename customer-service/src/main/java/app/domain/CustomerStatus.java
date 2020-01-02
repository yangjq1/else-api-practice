package app.domain;

import core.framework.db.DBEnumValue;

/**
 * @author Else
 */
public enum CustomerStatus {
    @DBEnumValue("ACTIVE")
    ACTIVE,
    @DBEnumValue("INACTIVE")
    INACTIVE
}
