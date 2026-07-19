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
public interface QuestionSource {
    public List<Question> loadQuestion();
}
