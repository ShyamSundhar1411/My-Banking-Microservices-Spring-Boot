package com.bank.loans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data @AllArgsConstructor @Getter
public class ResponseDto {
    private String statusCode;
    private String statusMessage;

}
