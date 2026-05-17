package dev.java.management.controller;
import dev.java.management.request.PositionRequest;
import dev.java.management.response.PositionResponse;
import dev.java.management.mapper.PositionMapper;
import dev.java.management.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService service;

    @PostMapping()
    public ResponseEntity<PositionResponse> create(@RequestBody PositionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).
                body(PositionMapper.toPositionResponse(service.save(PositionMapper.toPosition(request))));
    }

    @GetMapping()
    public ResponseEntity<List<PositionResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(PositionMapper::toPositionResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PositionResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(PositionMapper.toPositionResponse(service.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
            return ResponseEntity.noContent().build();
        }

    }


