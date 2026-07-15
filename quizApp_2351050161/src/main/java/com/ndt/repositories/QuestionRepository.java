/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.repositories;

import com.ndt.pojo.Choice;
import com.ndt.pojo.Question;
import com.ndt.quizapp.JdbcConnector;
import com.ndt.quizapp.QuestionQueryBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class QuestionRepository {
    public List<Question> getListQuestion(String kw, Integer categoryId, Integer levelId, int limit) {
        QuestionQueryBuilder query = new QuestionQueryBuilder()
                    .categoryId(categoryId)
                    .levelId(levelId)
                    .limit(limit);
            
        List<Question> questions = new ArrayList<>();
        System.out.println(query.builder());
        System.out.println("size: " + query.getParams().size());
        try {
            Connection conn = JdbcConnector.getInstance().connect();
            PreparedStatement stm = conn.prepareStatement(query.builder());
            int idx = 1;
            for (Object param: query.getParams()) {
                stm.setObject(idx, param);
                idx++;
            }
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()) {
                int questionId = rs.getInt("id");
                Question question = new Question(
                        questionId, 
                        rs.getString("content"), 
                        rs.getString("level"), 
                        rs.getString("category"), 
                        rs.getString("hint"), 
                        rs.getString("image"), 
                        new ArrayList<>());
                questions.add(question);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QuestionRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }
    
    public boolean addQuestion(Question question) throws SQLException {
        Connection conn = JdbcConnector.getInstance().connect();
        
        String sqlQuery = "INSERT INTO question(content,hint,image,category_id,level_id) " + "VALUES(?, ?, ?, ?, ?)";
        
        int categoryId = getCategoryId(question.getCategory());
        int levelId = getLevelId(question.getLevel());
        
        PreparedStatement stm = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, question.getContent());       
        stm.setString(2, question.getHint());
        stm.setString(3, question.getImage());
        stm.setInt(4, categoryId);
        stm.setInt(5, levelId);
        
        stm.executeUpdate();
        
        ResultSet rs = stm.getGeneratedKeys();
        
        int questionId = -1;
        if(rs.next()) {
            questionId = rs.getInt(1);
        }
        
        for(Choice choice: question.getChoice()) {
            InsertChoice(conn, choice, questionId);
        }
        
        return questionId != -1;
    }

    private Integer getCategoryId(String category) {
        switch (category) {
            case "Grammar":
                return 1;
            case "Vocabulary":
                return 2;
            case "Reading":
                return 3;
            default:
                return null;
        }
    }

    private Integer getLevelId(String level) {
        switch (level) {
            case "Easy":
                return 1;
            case "Medium":
                return 2;
            case "Hard":
                return 3;
            default:
                return null;
        }
    }

    private void InsertChoice(Connection conn, Choice choice, int questionId) throws SQLException {
        String sqlQuery = "INSERT INTO choice(content,is_correct,question_id)" + "VALUES(?, ?, ?)";
        
        PreparedStatement stm = conn.prepareStatement(sqlQuery);
        stm.setString(1, choice.getContent());
        stm.setInt(2, choice.getIs_correct()? 1 : 0);
        stm.setInt(3, questionId);
    }
}
