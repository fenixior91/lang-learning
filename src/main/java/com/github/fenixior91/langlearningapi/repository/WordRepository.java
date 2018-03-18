package com.github.fenixior91.langlearningapi.repository;

import com.github.fenixior91.langlearningapi.enums.Language;
import com.github.fenixior91.langlearningapi.enums.WordType;
import com.github.fenixior91.langlearningapi.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    @Query("SELECT word FROM Word AS word WHERE (:progress is null OR word.progress = :progress)" +
            "AND (:wordType IS NULL OR word.wordType = :wordType)" +
            "AND (:language IS NULL OR word.language = :language)")
    List<Word> findAll(
            @Param("progress") Integer progress,
            @Param("wordType") WordType wordType,
            @Param("language") Language language
    );

    List<Word> findWordsByPhrase(String phrase);
}
