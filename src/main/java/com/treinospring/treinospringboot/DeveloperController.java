package com.treinospring.treinospringboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/developer")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    public List<Developer> getDevelopers(){
        return developerService.getAllDevelopers();
    }

    @PostMapping
    public void addNewDeveloper( @RequestBody Developer developer){
            developerService.insertDeveloper(developer);

    }

    @GetMapping("{id}")
    public Developer getDeveloperById(@PathVariable Integer id){
        return developerService.getDeveloperById(id);
    }

    @DeleteMapping("{id}")
    public void deleteDeveloperById(@PathVariable Integer id){
        developerService.deleteDeveloperById(id);
    }

    @PutMapping("{id}")
    public void updateDeveloperById(@PathVariable Integer id, @RequestBody Developer developer){
        developerService.updateDeveloperById(id, developer);
    }
}
