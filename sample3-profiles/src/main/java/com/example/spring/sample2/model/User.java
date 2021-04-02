package com.example.spring.sample2.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    private long id;

    private String login;

    private String name;

}
