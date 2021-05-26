package com.rosyidgrobogan.belajarspringapi.models.enities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    @Column(name = "product_name", length = 100)
    private String name;

    @NotEmpty(message = "Desctiption is required")
    @Column(name = "desctiption", length = 500)
    private String description;

    private double price;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "product_supplier",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private Set<Supplier> suppliers;
}
