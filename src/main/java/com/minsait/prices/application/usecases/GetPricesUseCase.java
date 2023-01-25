package com.minsait.prices.application.usecases;

import com.minsait.prices.application.models.GetPricesCommand;
import com.minsait.prices.domain.models.Price;
import com.minsait.prices.domain.repositories.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GetPricesUseCase {
    private PricesRepository repository;

    @Autowired
    public GetPricesUseCase(PricesRepository repository){
        this.repository = repository;
    }

    public Price execute(GetPricesCommand command){
        return this.repository.getAllPrices(command.applicationDate, command.productId, command.brandId);
    }
}
