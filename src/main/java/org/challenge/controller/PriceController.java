package org.challenge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.challenge.dto.PriceDTO;
import org.challenge.mapper.PriceMapper;
import org.challenge.service.PriceService;
import org.challenge.util.ControllerHelper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static org.challenge.util.ControllerHelper.PRICE_CONTROLLER_PATH;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = PRICE_CONTROLLER_PATH, produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PriceController {

    private final PriceMapper priceMapper;
    private final PriceService priceService;

    @Operation(summary = "get price",
            responses = {
                    @ApiResponse(responseCode = "200", description = "price",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PriceDTO.class))
                            }),
                    @ApiResponse(responseCode = "204", description = "not price content", content = @Content)
            }
    )
    @GetMapping
    public ResponseEntity<PriceDTO> getPrice(
            @RequestParam(value = "applicationDate")
            @Schema(description = "Application date", required = true, example = "2020-06-14T10:00:00", format = "yyyy-MM-ddTHH:mm:ss")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam(value = "productId", required = true)
            @Schema(description = "Product Id", required = true) int productId,
            @RequestParam(value = "brandId", required = true)
            @Schema(description = "Brand Id", required = true) int brandId
    ) throws NotFoundException {
        final LocalDateTime startTime = LocalDateTime.now();

        final PriceDTO response = priceMapper.toDTO(priceService.getPrice(applicationDate, productId, brandId));

        final HttpHeaders httpHeaders = ControllerHelper.buildHeaders(startTime);
        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

}
