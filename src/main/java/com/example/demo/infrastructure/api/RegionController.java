package com.example.demo.infrastructure.api;

import javax.validation.Valid;

import java.util.Objects;

import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.usecase.CreateRegion;
import com.example.demo.application.usecase.GetRegions;
import com.example.demo.application.usecase.dto.input.CreateRegionInput;
import com.example.demo.infrastructure.api.dto.request.CreateRegionRequest;
import com.example.demo.infrastructure.api.dto.response.RegionResponse;

@RestController
@RequestMapping(value = "/api/v1")
public class RegionController {
    private final ConversionService converter;
    private final GetRegions getRegions;
    private final CreateRegion createRegion;

    public RegionController(
            ConversionService converter,
            GetRegions getRegions,
            CreateRegion createRegion
    ) {
        this.converter = converter;
        this.getRegions = getRegions;
        this.createRegion = createRegion;
    }

    @GetMapping(value = "/regions")
    public Page<RegionResponse> getRegions(Pageable pageable) {
        return getRegions.execute(pageable)
                         .map(output -> converter.convert(output, RegionResponse.class));
    }

    @PostMapping(value = "/regions")
    public RegionResponse createRegion(
            @Valid @RequestBody CreateRegionRequest request
    ) {
        var input = Objects.requireNonNull(converter.convert(request, CreateRegionInput.class));
        var output = createRegion.execute(input);

        return converter.convert(output, RegionResponse.class);
    }
}
