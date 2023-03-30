package br.com.cleudeir.linguagensapi;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private LanguageRepository repository;

    @GetMapping(value = "/")
    public String getOnline() {
        return "online";
    }

    @GetMapping(value = "/languages")
    public List<Language> getLanguages() {
        List<Language> languages = repository.findAll(Sort.by(Direction.ASC, "ranking"));
        return languages;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> postAdd(@RequestBody Language newLanguage) {
        System.out.println("newLanguage" + newLanguage);
        repository.save(newLanguage);
        return ResponseEntity.status(201).build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> putUpdate(@PathVariable String id, @RequestBody Language newInfo) {
        Language newLanguage = new Language(
                newInfo.getTitle(),
                newInfo.getImage(),
                newInfo.getDescription(),
                newInfo.getRanking(),
                newInfo.getOrigin());
        newLanguage.setId(id);
        repository.save(newLanguage);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteUpdate(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}