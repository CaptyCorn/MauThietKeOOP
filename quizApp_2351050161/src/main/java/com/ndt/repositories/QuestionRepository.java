/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.repositories;

import com.ndt.pojo.Choice;
import com.ndt.pojo.Question;
import com.ndt.quizapp.JdbcConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class QuestionRepository {
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
        
        stm.executeQuery();
        
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
