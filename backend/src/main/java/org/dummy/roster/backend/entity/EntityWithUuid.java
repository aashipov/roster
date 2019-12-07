package org.dummy.roster.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Сущность с ID;
 */
@MappedSuperclass
public class EntityWithUuid implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;

    /**
     * Первичный ключ.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public EntityWithUuid setUuid(UUID u) {
        this.uuid = u;
        return this;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof EntityWithUuid)) {
            return 1;
        }
        return this.uuid.compareTo(((EntityWithUuid) o).getUuid());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EntityWithUuid that = (EntityWithUuid) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}