package com.example.antoine.examapp.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuestionsDAO {

    @Query("SELECT * FROM Questions")
    List<Questions> getQuestions();

    @Insert
    void insertQuestion(Questions questions);

    @Delete
    void deleteQuestion(Questions questions);

    @Query("DELETE FROM Questions WHERE id=:id")
    void deleteQuestionById(int id);
}
