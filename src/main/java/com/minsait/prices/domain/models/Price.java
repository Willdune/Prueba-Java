package com.minsait.prices.domain.models;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Price {
    public long id;

    public long brandId;

    public Timestamp startDate;

    public Timestamp endDate;

    public long priceList;

    public long productId;

    public long priority;

    public float price;

    public String currency;
}
