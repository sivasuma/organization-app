package com.mycompany.app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mycompany.app.service.UserMapService;
import com.mycompany.app.common.Document;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserMapService service;

    @PostMapping
    public Document create(@RequestBody Document doc){
        return service.save(doc);
    }

    @GetMapping("/{id}")
    public Document get(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Document> getAll(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Document update(@PathVariable Long id, @RequestBody Document doc){
        return service.update(id, doc);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }
}
