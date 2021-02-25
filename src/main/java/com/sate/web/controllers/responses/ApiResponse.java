package com.sate.web.controllers.responses;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private String message;
    private int statusCode;
}
