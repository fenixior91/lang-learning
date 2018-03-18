package com.github.fenixior91.langlearningapi.controller;

import com.github.fenixior91.langlearningapi.enums.Language;
import com.github.fenixior91.langlearningapi.enums.WordType;
import com.github.fenixior91.langlearningapi.model.Word;
import com.github.fenixior91.langlearningapi.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WordController {

    @Autowired
    private WordService wordService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/words")
    public ResponseEntity<List<Word>> findAll(
            @RequestParam(name = "progress", required = false) Integer progress,
            @RequestParam(name = "wordType", required = false) WordType wordType,
            @RequestParam(name = "language", required = false) Language language) {
        List<Word> words = wordService.findAll(progress, wordType, language);
        return ResponseEntity.status(words.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(words);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/words/{phrase}")
    public ResponseEntity<Word> findWordByPhrase(@PathVariable("phrase") String phrase)
            throws EntityNotFoundException {
        return ResponseEntity.ok(wordService.findWordByPhrase(phrase));
    }

    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/words")
    public ResponseEntity addWord(@Valid @RequestBody Word word) {
        wordService.save(word);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/words")
    public ResponseEntity updateWord(@Valid @RequestBody Word word) {
        return ResponseEntity.ok(wordService.save(word));
    }
}
