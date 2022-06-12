package com.searcHours.demo.domain.models;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;

}
