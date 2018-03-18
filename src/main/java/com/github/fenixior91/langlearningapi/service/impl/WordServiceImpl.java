package com.github.fenixior91.langlearningapi.service.impl;

import com.github.fenixior91.langlearningapi.enums.Language;
import com.github.fenixior91.langlearningapi.enums.WordType;
import com.github.fenixior91.langlearningapi.model.Word;
import com.github.fenixior91.langlearningapi.repository.WordRepository;
import com.github.fenixior91.langlearningapi.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordRepository wordRepository;

    @Override
    public List<Word> findAll(Integer progress, WordType wordType, Language language) {
        return wordRepository.findAll(progress, wordType, language);
    }

    @Override
    public List<Word> findWordsByPhrase(String phrase) {
        return wordRepository.findWordsByPhrase(phrase);
    }
}
