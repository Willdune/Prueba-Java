package com.minsait.prices.infrastructure.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
public class GetPricesRequestDTO {
    public Timestamp applicationDate;
    public long productId;
    public long brandId;
}
