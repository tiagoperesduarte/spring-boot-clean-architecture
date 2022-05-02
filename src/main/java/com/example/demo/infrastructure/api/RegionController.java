package com.example.demo.infrastructure.api;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.factory.CreateRegionInputFactory;
import com.example.demo.common.factory.RegionResponseFactory;
import com.example.demo.infrastructure.api.dto.request.CreateRegionRequest;
import com.example.demo.infrastructure.api.dto.response.RegionResponse;
import com.example.demo.usecase.CreateRegion;
import com.example.demo.usecase.GetRegions;

@RestController
@RequestMapping(value = "/api/v1")
public class RegionController {
    private final GetRegions getRegions;
    private final CreateRegion createRegion;

    public RegionController(
            GetRegions getRegions,
            CreateRegion createRegion
    ) {
        this.getRegions = getRegions;
        this.createRegion = createRegion;
    }

    @GetMapping(value = "/regions")
    public Page<RegionResponse> getRegions(Pageable pageable) {
        return getRegions.execute(pageable)
                         .map(RegionResponseFactory::of);
    }

    @PostMapping(value = "/regions")
    public RegionResponse createRegion(
            @Valid @RequestBody CreateRegionRequest request
    ) {
        var region = createRegion.execute(CreateRegionInputFactory.of(request));
        return RegionResponseFactory.of(region);
    }
}
