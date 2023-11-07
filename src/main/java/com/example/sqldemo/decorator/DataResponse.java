package com.example.sqldemo.decorator;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class DataResponse<T> {

    T data;
    Response response;
}
