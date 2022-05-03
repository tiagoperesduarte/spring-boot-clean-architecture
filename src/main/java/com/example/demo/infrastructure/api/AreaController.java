package com.example.demo.infrastructure.api;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.factory.AreaResponseFactory;
import com.example.demo.core.factory.CreateAreaInputFactory;
import com.example.demo.domain.usecase.CreateArea;
import com.example.demo.domain.usecase.DeleteArea;
import com.example.demo.domain.usecase.GetArea;
import com.example.demo.domain.usecase.GetAreas;
import com.example.demo.infrastructure.api.dto.request.CreateAreaRequest;
import com.example.demo.infrastructure.api.dto.response.AreaResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class AreaController {
    private final GetAreas getAreas;
    private final GetArea getArea;
    private final CreateArea createArea;
    private final DeleteArea deleteArea;

    public AreaController(
            GetAreas getAreas,
            GetArea getArea,
            CreateArea createArea,
            DeleteArea deleteArea
    ) {
        this.getAreas = getAreas;
        this.getArea = getArea;
        this.createArea = createArea;
        this.deleteArea = deleteArea;
    }

    @GetMapping(value = "/areas")
    public Page<AreaResponse> getAreas(Pageable pageable) {
        log.debug("Request to find all areas by query (query={})", pageable);

        return getAreas.execute(pageable)
                       .map(AreaResponseFactory::of);
    }

    @GetMapping(value = "/areas/{areaId}")
    public AreaResponse getArea(@PathVariable String areaId) {
        log.debug("Request to find area by id (id={})", areaId);

        var area = getArea.execute(areaId);
        return AreaResponseFactory.of(area);
    }

    @PostMapping(value = "/areas")
    @ResponseStatus(HttpStatus.CREATED)
    public AreaResponse createArea(
            @Valid @RequestBody CreateAreaRequest request
    ) {
        log.debug("Request to create new area with data (data={})", request);

        var area = createArea.execute(CreateAreaInputFactory.of(request));
        return AreaResponseFactory.of(area);
    }

    @DeleteMapping(value = "/areas/{areaId}")
    public ResponseEntity<?> deleteArea(@PathVariable String areaId) {
        log.debug("Request to delete area by id (id={})", areaId);

        deleteArea.execute(areaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
