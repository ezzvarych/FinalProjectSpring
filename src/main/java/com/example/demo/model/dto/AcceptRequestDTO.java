package com.example.demo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AcceptRequestDTO {
    private Long requestId;
    private int price;
}
