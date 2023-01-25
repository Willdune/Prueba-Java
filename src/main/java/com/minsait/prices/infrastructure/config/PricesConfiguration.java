package com.minsait.prices.infrastructure.config;

import com.minsait.prices.application.usecases.GetPricesUseCase;
import com.minsait.prices.domain.repositories.PricesRepository;
import com.minsait.prices.infrastructure.repositories.H2PricesRepository;
import com.minsait.prices.infrastructure.repositories.jpa.JpaPricesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PricesConfiguration {

    @Bean
    public GetPricesUseCase getPricesUseCase(PricesRepository pricesRepository){
        return new GetPricesUseCase(pricesRepository);
    }

    @Bean
    public PricesRepository pricesRepository(ModelMapper mapper, JpaPricesRepository pricesRepository){
        return new H2PricesRepository(mapper, pricesRepository);
    }
}
