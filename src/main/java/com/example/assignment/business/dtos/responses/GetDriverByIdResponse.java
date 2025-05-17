package com.example.assignment.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetDriverByIdResponse {
    private int id;

    private String name;

    private String address;

    private String phone;
}
