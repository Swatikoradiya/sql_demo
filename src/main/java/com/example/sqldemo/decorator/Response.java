package com.example.sqldemo.decorator;

import com.example.sqldemo.constant.MessageConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    int code;
    HttpStatus status;

    String description;

    public static Response getCreatedResponse(String message) {
        return new Response(HttpStatus.CREATED.value(), HttpStatus.CREATED, message);
    }

    public static Response getSuccessResponse() {
        return new Response(HttpStatus.OK.value(), HttpStatus.OK, MessageConstant.SUCCESS);
    }

    public static Response getInternalServerErrorResponse(String message) {
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
