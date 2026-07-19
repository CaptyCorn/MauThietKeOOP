/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.quizapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionQueryBuilder {
    private Integer categoryId;
    private Integer levelId;
    private String kw;
    
    private int limit;
    private List<Object> params = new ArrayList<>();

    public QuestionQueryBuilder() {
    }

    public QuestionQueryBuilder(Integer categoryId, Integer levelId, String kw) {
        this.categoryId = categoryId;
        this.levelId = levelId;
        this.kw = kw;
    }
    
    public String builder() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT q.id, q.content, q.hint, q.image, q.category_id, q.level_id ");
        sqlBuilder.append("FROM question q ");
        sqlBuilder.append("INNER JOIN category c ON q.category_id = c.id ");
        sqlBuilder.append("INNER JOIN level lv ON q.level_id = lv.id ");
        sqlBuilder.append("WHERE 1=1 ");
        
        if (kw != null) {
            sqlBuilder.append("AND q.content LIKE ? ");
            params.add("%" + kw + "%");
        }
        
        if (categoryId != null) {
            sqlBuilder.append("AND q.category_id = ? ");
            params.add(categoryId);
        }
        
        if (levelId != null) {
            sqlBuilder.append("AND q.level_id = ? ");
            params.add(levelId);
        }
        sqlBuilder.append("ORDER BY q.id LIMIT ? ");
        params.add(limit);
        
        return sqlBuilder.toString();
    }

    /**
     * @return the params
     */
    public List<Object> getParams() {
        return params;
    }
    
    public QuestionQueryBuilder categoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }
    
    public QuestionQueryBuilder levelId(Integer levelId) {
        this.levelId = levelId;
        return this;
    }
    
    public QuestionQueryBuilder limit (int limit) {
        this.limit = limit;
        return this;
    }
}
