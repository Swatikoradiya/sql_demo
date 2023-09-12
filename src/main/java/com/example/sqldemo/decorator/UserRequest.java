package com.example.sqldemo.decorator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {

    String firstName;

    String lastName;

    String fullName;

    String email;

    String phone;
}
