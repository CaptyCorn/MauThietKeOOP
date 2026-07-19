/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.quizapp;

import com.ndt.pojo.Question;
import java.util.List;

/**
 *
 * @author admin
 */
public class FileQuesstionAdapter implements QuestionSource {
    private FileQuestionParser adaptee;
    private String category;
    private String level;

    public FileQuesstionAdapter(FileQuestionParser adaptee, String category, String level) {
        this.adaptee = adaptee;
        this.category = category;
        this.level = level;
    }
    
    @Override
    public List<Question> loadQuestion() {
        return this.adaptee.parse(category, level);
    }
    
}
