package com.minsait.prices.infrastructure.repositories.schemas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@Data
@Table(name = "PRICES")
@NoArgsConstructor
public class PricesSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    @Column
    public long brandId;
    @Column
    public Timestamp startDate;
    @Column
    public Timestamp endDate;
    @Column
    public long priceList;
    @Column
    public long productId;
    @Column
    public long PRIORITY;
    @Column
    public float price;
    @Column
    public String currency;
}
