package com.example.droolslab.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequest {
    private Integer orderId;
    private String paymentType;
    private Integer totalPrice;
    private Integer discount;

}
