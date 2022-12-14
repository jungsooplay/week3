package com.sparta.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    public Memo(String title, String contents, String author, String password) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.password = password;
    }

    public Memo(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
    }

    public void update(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
    }
}
