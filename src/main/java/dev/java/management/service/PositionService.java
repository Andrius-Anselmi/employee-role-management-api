package dev.java.management.service;

import dev.java.management.exception.ExceptionMessages;
import dev.java.management.exception.NotFoundException;
import dev.java.management.repository.PositionRepository;
import dev.java.management.entity.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {

    private final PositionRepository positionRepository;

    public Position save(Position cargo) {
        return positionRepository.save(cargo);
    }
    
    public List<Position> findAll() {
        return  positionRepository.findAll();
    }

    public Position findById(Long id) {
        return positionRepository.findById(id).
                orElseThrow(() -> new NotFoundException(ExceptionMessages.POSITION_NOT_FOUND));
    }

    public void delete(Long id) {
        if (!positionRepository.existsById(id)){
            throw new NotFoundException(ExceptionMessages.POSITION_NOT_FOUND);
        }
        positionRepository.deleteById(id);
    }


}
