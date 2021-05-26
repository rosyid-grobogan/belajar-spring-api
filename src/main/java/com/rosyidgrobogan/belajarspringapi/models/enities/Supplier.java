package com.rosyidgrobogan.belajarspringapi.models.enities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "suppliers")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private String address;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Product> products;
}
