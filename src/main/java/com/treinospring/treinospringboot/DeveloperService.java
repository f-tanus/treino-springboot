package com.treinospring.treinospringboot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {
    private final DeveloperRepository developerRepository;
    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public void insertDeveloper(Developer developer) {
        developerRepository.save(developer);
    }

    public Developer getDeveloperById(Integer id) {
        return developerRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(id+"not found"));
    }

    public void deleteDeveloperById(Integer id) {
        boolean exists = developerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(id+"does not exist");
        }
        developerRepository.deleteById(id);
    }

    public void updateDeveloperById(Integer id, Developer developer) {
        boolean exists = developerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(id+"does not exist");
        }
        developer.setId(id);
        developerRepository.save(developer);
    }
}
