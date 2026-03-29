package com.mycompany.app.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.mycompany.app.common.Document;
import com.mycompany.app.entity.User;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapService {

    @Autowired
    private UserService service;

    public Document save(Document doc) {

        return service.save(doc);
        //return mapToDocument(obj);
    }

    public Document findById(Long id) {
        return  service.findById(id);
       // return mapToDocument(obj);
    }

    public List<Document> findAll() {
        return service.findAll();
        //return list.stream().map(this::mapToDocument).collect(Collectors.toList());
    }

    public Document update(Long id, Document doc) {
      //  User obj = mapToEntity(doc);
        return service.update(id, doc);
        //return mapToDocument(obj);
    }

    public void deleteById(Long id) {
        service.deleteById(id);
    }

//    private User mapToEntity(Document doc) {
//        User obj = new User();
//User
//        return obj;
//    }

//    private Document mapToDocument(User obj) {
//        Document doc = new Document();
//User
//        return doc;
//    }
}
