package com.wjh.learn.second.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private int id;
    private String username;
    private String grade;
    private String comment;

}
