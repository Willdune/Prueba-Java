package com.minsait.prices.infrastructure.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
public class GetPricesResponseDTO {
    public long productId;
    public long brandId;
    public long priceList;
    public Timestamp startDate;
    public Timestamp endDate;
    public float price;
}
