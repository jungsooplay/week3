package com.sparta.domain;

import lombok.Getter;

@Getter
public class MemoRequestDto {
    private String title;
    private String contents;
    private String author;
    private String password;
}
