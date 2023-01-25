package com.minsait.prices.domain.repositories;

import com.minsait.prices.domain.models.Price;

import java.sql.Timestamp;

public interface PricesRepository {
    Price getAllPrices(Timestamp applicationDate, long productId, long brandId);
}
