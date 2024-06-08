package com.webserver.webserver.question;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class QuestionRepository {
    private Map<Long, Question> questionMap = new HashMap<>();
    private AtomicLong counter = new AtomicLong();

    public List<Question> findAll() {
        return new ArrayList<>(questionMap.values());
    }

    public Question findById(Long id) {
        return questionMap.get(id);
    }

    public Question save(Question question) {
        Long id = counter.incrementAndGet();
        question.setId(id);
        questionMap.put(id, question);
        return question;
    }

    // Add method to add answer to question by id
    public void addAnswer(Long id, String answer) {
        Question question = questionMap.get(id);
        if (question != null) {
            question.addAnswer(answer);
        }
    }
}
