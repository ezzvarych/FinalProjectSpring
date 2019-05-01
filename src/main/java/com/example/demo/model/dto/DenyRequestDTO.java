package com.example.demo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DenyRequestDTO {
    private Long requestId;
    private String denyReason;
}
