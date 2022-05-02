package com.example.demo.infrastructure.api;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.factory.AreaResponseFactory;
import com.example.demo.common.factory.CreateAreaInputFactory;
import com.example.demo.infrastructure.api.dto.request.CreateAreaRequest;
import com.example.demo.infrastructure.api.dto.response.AreaResponse;
import com.example.demo.usecase.CreateArea;
import com.example.demo.usecase.GetAreas;

@RestController
@RequestMapping(value = "/api/v1")
public class AreaController {
    private final GetAreas getAreas;
    private final CreateArea createArea;

    public AreaController(
            GetAreas getAreas,
            CreateArea createArea
    ) {
        this.getAreas = getAreas;
        this.createArea = createArea;
    }

    @GetMapping(value = "/areas")
    public Page<AreaResponse> getAreas(Pageable pageable) {
        return getAreas.execute(pageable)
                       .map(AreaResponseFactory::of);
    }

    @PostMapping(value = "/areas")
    public AreaResponse createArea(
            @Valid @RequestBody CreateAreaRequest request
    ) {
        var area = createArea.execute(CreateAreaInputFactory.of(request));
        return AreaResponseFactory.of(area);
    }
}
