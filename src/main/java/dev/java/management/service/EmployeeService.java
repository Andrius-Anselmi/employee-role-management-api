package dev.java.management.service;

import dev.java.management.entity.Position;
import dev.java.management.entity.Employee;
import dev.java.management.exception.ExceptionMessages;
import dev.java.management.exception.NotFoundException;
import dev.java.management.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final PositionService positionService;

    public Employee save(Employee employee) {
        Position position = validatePosition(employee.getPosition().getId());
        employee.setPosition(position);
        return repository.save(employee);
    }
    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findById(Long id) {
        return repository.
                findById(id).orElseThrow(() -> new NotFoundException(ExceptionMessages.EMPLOYEE_NOT_FOUND));
    }

    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new NotFoundException(ExceptionMessages.EMPLOYEE_NOT_FOUND);
        }
        repository.deleteById(id);
    }

    private Position validatePosition(Long id){
        return positionService.findById(id);
    }
}



