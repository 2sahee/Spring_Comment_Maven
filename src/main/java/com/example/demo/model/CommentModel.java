package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentModel {
    private int no;
    @JsonIgnore
    private String author;
    private String comment;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;

}
