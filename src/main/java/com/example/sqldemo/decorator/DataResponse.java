package com.example.sqldemo.decorator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DataResponse<T> {

    T data;
    Response response;
}
