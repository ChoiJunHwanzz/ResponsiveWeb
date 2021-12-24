package com.example.backend.entity;


import com.example.backend.request.GongziRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="gongzi")
public class Gongzi extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gongzi_no", nullable = false)
    private Long gongziNo;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column
    private Integer view = 0;

    public Gongzi(String title, String writer, String description) {
        this.title = title;
        this.writer = writer;
        this.description = description;
    }

    public void updateGongzi(GongziRequest request) {
        this.title = request.getTitle();
        this.description = request.getDescription();
    }
}
