package com.example.demo.infrastructure.api;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

import com.example.demo.domain.usecase.CreateAreaUseCase;
import com.example.demo.domain.usecase.DeleteAreaUseCase;
import com.example.demo.domain.usecase.GetAreaUseCase;
import com.example.demo.domain.usecase.GetAreasUseCase;
import com.example.demo.domain.usecase.input.GetAreasInput;
import com.example.demo.infrastructure.api.request.CreateAreaRequest;
import com.example.demo.infrastructure.api.response.AreaResponse;

@RestController
@RequestMapping(value = "/api/v1")
public class AreaController {
    private final GetAreasUseCase getAreasUseCase;
    private final GetAreaUseCase getAreaUseCase;
    private final CreateAreaUseCase createAreaUseCase;
    private final DeleteAreaUseCase deleteAreaUseCase;

    public AreaController(
            GetAreasUseCase getAreasUseCase,
            GetAreaUseCase getAreaUseCase,
            CreateAreaUseCase createAreaUseCase,
            DeleteAreaUseCase deleteAreaUseCase
    ) {
        this.getAreasUseCase = getAreasUseCase;
        this.getAreaUseCase = getAreaUseCase;
        this.createAreaUseCase = createAreaUseCase;
        this.deleteAreaUseCase = deleteAreaUseCase;
    }

    @GetMapping(value = "/areas")
    public Page<AreaResponse> getAreas(Pageable pageable) {
        var input = new GetAreasInput(pageable.getPageNumber(), pageable.getPageSize());
        var simplePage = getAreasUseCase.execute(input)
                                        .map(AreaResponse::of);

        return new PageImpl<>(simplePage.getContent(), pageable, simplePage.getTotalElements());
    }

    @GetMapping(value = "/areas/{areaId}")
    public AreaResponse getArea(@PathVariable String areaId) {
        var area = getAreaUseCase.execute(areaId);
        return AreaResponse.of(area);
    }

    @PostMapping(value = "/areas")
    @ResponseStatus(HttpStatus.CREATED)
    public AreaResponse createArea(@Valid @RequestBody CreateAreaRequest request) {
        var area = createAreaUseCase.execute(request.toInput());
        return AreaResponse.of(area);
    }

    @DeleteMapping(value = "/areas/{areaId}")
    public ResponseEntity<?> deleteArea(@PathVariable String areaId) {
        deleteAreaUseCase.execute(areaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
