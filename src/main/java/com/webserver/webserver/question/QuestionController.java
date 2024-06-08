package com.webserver.webserver.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping
    public String getAllQuestions(Model model) {
        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questions", questions);
        return "questions";
    }

    @GetMapping("/new")
    public String showAddQuestionForm(Model model) {
        model.addAttribute("question", new Question());
        return "addQuestion";
    }

    @PostMapping
    public String addQuestion(@ModelAttribute Question question, Model model) {
        questionRepository.save(question);
        return "redirect:/questions";
    }

    @GetMapping("/{id}")
    public String showQuestionDetail(@PathVariable Long id, Model model) {
        Question question = questionRepository.findById(id);
        model.addAttribute("question", question);
        return "questionDetail";
    }
    
    @PostMapping("/{id}/addAnswer")
    public String addAnswer(@PathVariable Long id, @RequestParam String answer) {
        questionRepository.addAnswer(id, answer);
        return "redirect:/questions/" + id;
    }
}
