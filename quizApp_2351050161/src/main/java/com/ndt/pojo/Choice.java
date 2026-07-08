/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.pojo;

/**
 *
 * @author admin
 */
public class Choice {
    private int id;
    private String content;
    private Boolean is_correct;

    public Choice(int id, String content, Boolean is_corect) {
        this.id = id;
        this.content = content;
        this.is_correct = is_corect;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the is_correct
     */
    public Boolean getIs_correct() {
        return is_correct;
    }

    /**
     * @param is_correct the is_correct to set
     */
    public void setIs_correct(Boolean is_correct) {
        this.is_correct = is_correct;
    }
    
    
}
