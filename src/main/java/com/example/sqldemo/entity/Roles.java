package com.example.sqldemo.entity;

import com.example.sqldemo.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Role name;

}
