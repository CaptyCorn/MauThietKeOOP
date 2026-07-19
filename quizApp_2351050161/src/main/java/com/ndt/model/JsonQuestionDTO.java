/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.model;

import java.util.List;

/**
 *
 * @author admin
 */
public class JsonQuestionDTO {
    private String content;
    private String hint;
    private List<JsonChoiceDTO> choices;

    public String getContent() {
        return content;
    }

    public String getHint() {
        return hint;
    }

    public List<JsonChoiceDTO> getChoices() {
        return choices;
    }
    
    
}
