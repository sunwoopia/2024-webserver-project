package com.webserver.webserver.question;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private Long id;
    private String title;
    private String content;
    private List<String> answers;

    // 생성자
    public Question() {
        answers = new ArrayList<>();
    }

    public Question(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answers = new ArrayList<>();
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void addAnswer(String answer) {
        answers.add(answer);
    }
}
