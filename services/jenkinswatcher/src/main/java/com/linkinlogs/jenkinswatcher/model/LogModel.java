package com.linkinlogs.jenkinswatcher.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class LogModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;

    private String name;

    @Id
    private String url;

    @Column(columnDefinition = "CLOB")
    private String contents;
}
