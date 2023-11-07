package com.example.sqldemo.decorator;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListResponse <T> {

    List<T> data;
    Response status;
}
