package com.minsait.prices.infrastructure.repositories.jpa;

import com.minsait.prices.infrastructure.repositories.schemas.PricesSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface JpaPricesRepository extends JpaRepository<PricesSchema, Long> {
    @Query(value = "SELECT * FROM PUBLIC.PRICES WHERE ?1 BETWEEN START_DATE AND END_DATE AND PRIORITY = ( SELECT MAX(PRIORITY) FROM PRICES ) AND PRODUCT_ID = ?2 AND BRAND_ID = ?3", nativeQuery = true)
    PricesSchema selectPrice(Timestamp date, long productId, long brandId);
}
