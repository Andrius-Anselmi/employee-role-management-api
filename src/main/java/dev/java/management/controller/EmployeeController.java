package dev.java.management.controller;

import dev.java.management.mapper.EmployeeMapper;
import dev.java.management.request.EmployeeRequest;
import dev.java.management.response.EmployeeResponse;
import dev.java.management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeResponse> create(@RequestBody EmployeeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).
                body(EmployeeMapper.toEmployeeResponse(employeeService.save(EmployeeMapper.toEmployee(request))));
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeResponse>> findAll() {
        return ResponseEntity.ok(employeeService.findAll().
                stream().map(EmployeeMapper::toEmployeeResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(EmployeeMapper.toEmployeeResponse(employeeService.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}





