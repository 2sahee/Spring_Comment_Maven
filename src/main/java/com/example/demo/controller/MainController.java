package com.example.demo.controller;

import com.example.demo.dao.CommentDAO;
import com.example.demo.dao.CommentJdbcDAO;
import com.example.demo.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CommentJdbcDAO commentJdbcDAO;

    @Autowired
    private CommentDAO commentDAO;

    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "") String name, Model model) {

        //List<Map<String, ?>> commentList = commentJdbcDAO.selectAllCommentList();

        List<CommentModel> cmList = commentDAO.selectAllComment();

        model.addAttribute("commentList", cmList);

        return "main";
    }

    @PostMapping("/comments")
    public String createComment(CommentModel commentModel) {

        System.out.println(commentModel.getAuthor());
        System.out.println(commentModel.getComment());

        commentDAO.insertComment(commentModel);

        return "redirect:/";
    }

    @DeleteMapping("/comments/{no}")
    public String deleteComment(@PathVariable int no) {

        commentDAO.deleteComment(no);

        return "redirect:/";
    }
}
