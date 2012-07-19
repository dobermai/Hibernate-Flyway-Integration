package de.dobermai.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author dobermai
 */
@Entity
public class TestEntity implements Serializable {
    private Long id;

    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
