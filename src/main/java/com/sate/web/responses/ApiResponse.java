package com.sate.web.responses;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private String message;
    private int statusCode;
    private T subResponse;
}
