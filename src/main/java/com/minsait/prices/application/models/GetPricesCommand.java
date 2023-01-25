package com.minsait.prices.application.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class GetPricesCommand {
    public Timestamp applicationDate;
    public long productId;
    public long brandId;
}
