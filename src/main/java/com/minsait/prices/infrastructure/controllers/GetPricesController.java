package com.minsait.prices.infrastructure.controllers;

import com.minsait.prices.application.models.GetPricesCommand;
import com.minsait.prices.application.usecases.GetPricesUseCase;
import com.minsait.prices.domain.models.Price;
import com.minsait.prices.infrastructure.models.GetPricesRequestDTO;
import com.minsait.prices.infrastructure.models.GetPricesResponseDTO;
import jakarta.persistence.NoResultException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/prueba/prices")
public class GetPricesController {
    private final GetPricesUseCase useCase;
    private final ModelMapper mapper;

    @Autowired
    public GetPricesController(GetPricesUseCase useCase, ModelMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @GetMapping(value = "/get-filtered")
    public ResponseEntity<?> getPricesFiltered(@RequestParam (name = "applicationDate") Timestamp applicationDate,
                                               @RequestParam(name = "productId") long productId,
                                               @RequestParam(name = "brandId") long brandId) {
        GetPricesCommand getPricesCommand = new GetPricesCommand(applicationDate, productId, brandId);
        Price price;
        try {
            price = this.useCase.execute(getPricesCommand);
        } catch (NoResultException resultException) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(mapper.map(price, GetPricesResponseDTO.class));
    }
}
