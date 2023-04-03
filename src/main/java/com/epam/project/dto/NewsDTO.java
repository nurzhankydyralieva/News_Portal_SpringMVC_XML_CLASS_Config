package com.epam.project.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsDTO {
    private Integer id;
    private String newsTitle;
    private LocalDate newsDate;
    private String brief;
    private String content;

}
