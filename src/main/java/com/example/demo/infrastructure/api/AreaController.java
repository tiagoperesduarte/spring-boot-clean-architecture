package com.example.demo.infrastructure.api;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.factory.AreaResponseFactory;
import com.example.demo.common.factory.CreateAreaInputFactory;
import com.example.demo.domain.usecase.CreateArea;
import com.example.demo.domain.usecase.GetAreaById;
import com.example.demo.domain.usecase.GetAreas;
import com.example.demo.infrastructure.api.dto.request.CreateAreaRequest;
import com.example.demo.infrastructure.api.dto.response.AreaResponse;
import com.example.demo.infrastructure.exception.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/api/v1")
public class AreaController {
    private final GetAreas getAreas;
    private final GetAreaById getAreaById;
    private final CreateArea createArea;

    public AreaController(
            GetAreas getAreas,
            GetAreaById getAreaById,
            CreateArea createArea
    ) {
        this.getAreas = getAreas;
        this.getAreaById = getAreaById;
        this.createArea = createArea;
    }

    @GetMapping(value = "/areas")
    public Page<AreaResponse> getAreas(Pageable pageable) {
        return getAreas.execute(pageable)
                       .map(AreaResponseFactory::of);
    }

    @GetMapping(value = "/areas/{areaId}")
    public AreaResponse getAreaById(@PathVariable String areaId) {
        return getAreaById.execute(areaId)
                          .map(AreaResponseFactory::of)
                          .orElseThrow(() -> new ResourceNotFoundException("Area not found with id " + areaId));
    }

    @PostMapping(value = "/areas")
    public AreaResponse createArea(
            @Valid @RequestBody CreateAreaRequest request
    ) {
        var area = createArea.execute(CreateAreaInputFactory.of(request));
        return AreaResponseFactory.of(area);
    }
}
