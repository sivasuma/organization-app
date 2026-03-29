package com.mycompany.app.service;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import com.mycompany.app.entity.User;
import com.mycompany.app.repository.UserRepository;
import com.mycompany.app.common.Document;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Document save(Document doc) {
        User entity = mapToEntity(doc);
        entity = repository.save(entity);
        return mapToDocument(entity);
    }

    public Document findById(Long id) {
        return repository.findById(id).map(this::mapToDocument).orElse(null);
    }

    public List<Document> findAll() {
        return repository.findAll().stream().map(this::mapToDocument).collect(Collectors.toList());
    }

    public Document update(Long id, Document doc) {
        User entity = mapToEntity(doc);
        entity.setId(id);
        entity = repository.save(entity);
        return mapToDocument(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private User mapToEntity(Document doc) {
        User entity = new User();
        doc.getMap().forEach((k,v) -> {
            try {
                var field = entity.getClass().getDeclaredField(k);
                field.setAccessible(true);
                field.set(entity, v);
            } catch (Exception e) { }
        });
        return entity;
    }

    private Document mapToDocument(User entity) {
        Document doc = new Document();
        doc.setEntity("User");
        Arrays.stream(entity.getClass().getDeclaredFields()).forEach(f -> {
            f.setAccessible(true);
            try { doc.put(f.getName(), f.get(entity)); } catch (Exception e) {}
        });
        return doc;
    }
}
