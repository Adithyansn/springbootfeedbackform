package com.example.demo.controller;

import com.example.demo.model.Feedback;
import com.example.demo.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // This handles form submissions (application/x-www-form-urlencoded)
    @PostMapping("/feedback")
@ResponseBody
public String submitFeedback(@RequestParam String name,
                             @RequestParam String bookName,
                             @RequestParam String feedback) {

    Feedback fb = new Feedback();
    fb.setName(name);
    fb.setBookName(bookName);
    fb.setFeedback(feedback);

    feedbackRepository.save(fb);

    return "Feedback saved successfully!";
    }
}
