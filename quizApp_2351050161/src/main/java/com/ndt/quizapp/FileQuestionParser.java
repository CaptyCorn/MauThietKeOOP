/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.quizapp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ndt.model.JsonChoiceDTO;
import com.ndt.model.JsonQuestionDTO;
import com.ndt.pojo.Choice;
import com.ndt.pojo.Question;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class FileQuestionParser {
    private String path;

    public FileQuestionParser(String path) {
        this.path = path;
    }
    
    public List<Question> parse(String category, String level) throws IOException {
        if (category == null) 
            throw new IllegalArgumentException("Chưa chọn danh mục");
        
        if (level == null)
            throw new IllegalArgumentException("Chưa chọn cấp độ");
        
        Path jsonFile = Path.of(this.path);
        
        if (!Files.exists(jsonFile))
            throw new IOException("Không tìm thấy file");
        
        Gson gson = new Gson();
        
        Type typeOfT = new TypeToken<List<JsonQuestionDTO>>(){}.getType();
        
        try(Reader reader = new FileReader(jsonFile.toFile().getAbsolutePath(), StandardCharsets.UTF_8)) {
            List<JsonQuestionDTO> lstQuestionDTO = gson.fromJson(reader, typeOfT);
            
            List<Question> lstQuestions = new ArrayList<>();
            for(int i = 0; i < lstQuestionDTO.size(); i++) {
                JsonQuestionDTO dto = lstQuestionDTO.get(i);
                
                List<Choice> choices = new ArrayList<>();
                for (JsonChoiceDTO choice : dto.getChoices())
                    choices.add(new Choice(choice.getContent(), choice.isCorrect()));
                
                Question.Builder builder = new Question.Builder()
                        .content(dto.getContent())
                        .hint(dto.getHint())
                        .category(category)
                        .level(level)
                        .choices(choices);
                Question question = new Question(builder);
                
                lstQuestions.add(question);
            }
            return lstQuestions;
            
        } catch (Exception e) {
        }
        
        return new ArrayList<>();
    }
}
