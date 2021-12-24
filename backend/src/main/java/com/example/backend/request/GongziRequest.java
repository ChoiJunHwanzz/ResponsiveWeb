package com.example.backend.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GongziRequest {
    private String title;
    private String writer;
    private String description;


    public GongziRequest(String title, String writer, String description) {
        this.title = title;
        this.writer = writer;
        this.description = description;
    }

}
