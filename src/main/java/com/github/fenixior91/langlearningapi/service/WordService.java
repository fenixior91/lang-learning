package com.github.fenixior91.langlearningapi.service;

import com.github.fenixior91.langlearningapi.enums.Language;
import com.github.fenixior91.langlearningapi.enums.WordType;
import com.github.fenixior91.langlearningapi.model.Word;

import java.util.List;

public interface WordService {

    List<Word> findAll(Integer progress, WordType wordType, Language language);

    List<Word> findWordsByPhrase(String phrase);
}
