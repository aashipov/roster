package org.dummy.roster.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Сущность с ID;
 */
@MappedSuperclass
public class EntityWithId implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;

    /**
     * Первичный ключ.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    public UUID getId() {
        return id;
    }

    public EntityWithId setId(UUID u) {
        this.id = u;
        return this;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof EntityWithId)) {
            return 1;
        }
        return this.id.compareTo(((EntityWithId) o).getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EntityWithId that = (EntityWithId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}