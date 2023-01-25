package com.minsait.prices.infrastructure.repositories;

import com.minsait.prices.domain.models.Price;
import com.minsait.prices.domain.repositories.PricesRepository;
import com.minsait.prices.infrastructure.repositories.jpa.JpaPricesRepository;
import com.minsait.prices.infrastructure.repositories.schemas.PricesSchema;
import jakarta.persistence.NoResultException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class H2PricesRepository implements PricesRepository {
    private ModelMapper mapper;
    private JpaPricesRepository pricesRepository;

    @Autowired
    public H2PricesRepository(ModelMapper mapper, JpaPricesRepository pricesRepository) {
        this.mapper = mapper;
        this.pricesRepository = pricesRepository;
    }

    @Override
    public Price getAllPrices(Timestamp date, long productId, long brandId) {
        PricesSchema result = this.pricesRepository.selectPrice(date, productId, brandId);
        if(result == null){
            throw new NoResultException();
        }
        return mapper.map(result, Price.class);
    }
}
