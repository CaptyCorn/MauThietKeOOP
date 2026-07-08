/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.pojo;

import com.ndt.pojo.Choice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Question implements Cloneable{
    private int id;
    private String content;
    private String level;
    private String category;
    private String hint;
    private String image;
    private List<Choice> choices;

    public Question(int id, String content, String level, String category, String hint, String image, List<Choice> choices) {
        this.id = id;
        this.content = content;
        this.level = level;
        this.category = category;
        this.hint = hint;
        this.image = image;
        this.choices = choices;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Question copy = (Question) super.clone();
        copy.choices = new ArrayList<>(this.choices);
        return copy;
    }

    
    
    private Question(Builder builder) {
        this.id = builder.id;
        this.content = builder.content;
        this.level = builder.level;
        this.category = builder.category;
        this.hint = builder.hint;
        this.image = builder.image;
        this.choices = builder.choices;
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
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the hint
     */
    public String getHint() {
        return hint;
    }

    /**
     * @param hint the hint to set
     */
    public void setHint(String hint) {
        this.hint = hint;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the choice
     */
    public List<Choice> getChoice() {
        return choices;
    }

    /**
     * @param choice the choice to set
     */
    public void setChoice(List<Choice> choices) {
        this.choices = choices;
    }
    
    public static class Builder{
        private int id;
        private String content;
        private String level;
        private String category;
        private String hint;
        private String image;
        private List<Choice> choices = new ArrayList<>();
        
        public Builder id (int id){
            this.id = id;
            return this;
        }
        
        public Builder content (String content){
            this.content = content;
            return this;
        }
        
        public Builder level (String level){
            this.level = level;
            return this;
        }
        
        public Builder category (String category){
            this.category = category;
            return this;
        }
        
        public Builder hint (String hint){
            this.hint = hint;
            return this;
        }
        
        public Builder image (String image){
            this.image = image;
            return this;
        }
        
        public Builder choices (List<Choice> choices) {
            this.choices = choices;
            return this;
        }
        
    }
    
    
}
