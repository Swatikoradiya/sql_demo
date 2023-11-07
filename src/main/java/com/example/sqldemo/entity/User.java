package com.example.sqldemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
//@NamedStoredProcedureQueries(@NamedStoredProcedureQuery(name = "firstProcedure", procedureName = "getAllUsers"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String firstName;

    String lastName;

    String fullName;

    String phone;

    /*@OneToOne
    Roles roles;*/

    String email;

    @JsonIgnore
    @Column(name = "softDelete")
    boolean softDelete;
}
