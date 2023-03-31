package com.epam.project.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "News")
public class News {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "News Title should not be empty")
    @Size(min = 10, max = 50, message = "News Title should be between 10 to 200 characters")
    @Column(name = "newsTitle")
    private String newsTitle;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Column(name = "newsDate")
    private LocalDate newsDate;
    @NotEmpty(message = "Brief should not be empty")
    @Size(min = 10, max = 500, message = "Brief should be between 10 to 500 characters")
    @Column(name = "brief")
    private String brief;
    @NotEmpty(message = "Content should not be empty")
    @Size(min = 10, max = 1000, message = "Content should be between 20 to 1000 characters")
    @Column(name = "content")
    private String content;
}
