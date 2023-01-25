package com.minsait.prices.application;

import com.minsait.prices.application.models.GetPricesCommand;
import com.minsait.prices.application.usecases.GetPricesUseCase;
import com.minsait.prices.domain.models.Price;
import com.minsait.prices.domain.repositories.PricesRepository;
import jakarta.persistence.NoResultException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import static org.mockito.Mockito.*;

public class GetPricesUseCaseTest {
    private final PricesRepository pricesRepository = new Mockito().mock(PricesRepository.class);

    private final GetPricesUseCase pricesUseCase = new GetPricesUseCase(pricesRepository);

    @Test
    public void whenUseCaseCalledAndResultMatchesDataReturnsExistingPrice(){
        GetPricesCommand correctCommand = new GetPricesCommand(
                new Timestamp(System.currentTimeMillis()),
                35455,
                1
        );

        Price expectedPrice = new Price(
                1,
                1,
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                1,
                35455,
                1,
                1,
                "EUR"
        );

        when(pricesRepository.getAllPrices(
                correctCommand.applicationDate,
                correctCommand.productId,
                correctCommand.brandId
        )).thenReturn(expectedPrice);

        Price result = pricesUseCase.execute(correctCommand);

        verify(pricesRepository, times(1)).getAllPrices(
                correctCommand.applicationDate,
                correctCommand.productId,
                correctCommand.brandId
        );
        assertEquals(expectedPrice, result);
    }

    @Test
    public void whenUseCaseCalledAndResultNotFoundReturnsNoResultException(){
        GetPricesCommand correctCommand = new GetPricesCommand(
                new Timestamp(System.currentTimeMillis()),
                35455,
                1
        );

        NoResultException expectedException = new NoResultException();

        when(pricesRepository.getAllPrices(
                correctCommand.applicationDate,
                correctCommand.productId,
                correctCommand.brandId
        )).thenThrow(expectedException);

        assertThrows(NoResultException.class, () -> pricesUseCase.execute(correctCommand));
    }
}
