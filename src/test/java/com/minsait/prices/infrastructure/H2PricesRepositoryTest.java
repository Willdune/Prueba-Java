package com.minsait.prices.infrastructure;

import com.minsait.prices.domain.models.Price;
import com.minsait.prices.domain.repositories.PricesRepository;
import com.minsait.prices.infrastructure.repositories.H2PricesRepository;
import com.minsait.prices.infrastructure.repositories.jpa.JpaPricesRepository;
import com.minsait.prices.infrastructure.repositories.schemas.PricesSchema;
import jakarta.persistence.NoResultException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class H2PricesRepositoryTest {

    private final JpaPricesRepository jpaPricesRepository = new Mockito().mock(JpaPricesRepository.class);

    private final ModelMapper modelMapper = new ModelMapper();

    private PricesRepository pricesRepository = new H2PricesRepository(modelMapper, jpaPricesRepository);

    @Test
    public void whenGetAllPricesIsCalledWithMatchingDataReturnsExistingPrice(){
        Timestamp date = new Timestamp(System.currentTimeMillis());
        long productId = 35455;
        long brandId = 1;

        PricesSchema expectedSchema = new PricesSchema(
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

        when(jpaPricesRepository.selectPrice(
                date,
                productId,
                brandId
        )).thenReturn(expectedSchema);

        Price result = pricesRepository.getAllPrices(date, productId, brandId);

        verify(jpaPricesRepository, times(1)).selectPrice(
                date,
                productId,
                brandId
        );
        assertEquals(expectedPrice, result);
    }

    @Test
    public void whenGetAllPricesIsCalledWithNonExistingResultsThrowsNoResultException(){
        Timestamp date = new Timestamp(System.currentTimeMillis());
        long productId = 35455;
        long brandId = 1;

        PricesSchema nullResult = null;

        when(jpaPricesRepository.selectPrice(
                date,
                productId,
                brandId
        )).thenReturn(nullResult);

        assertThrows(NoResultException.class, () -> pricesRepository.getAllPrices(
                date,
                productId,
                brandId
                )
        );
    }
}
