package com.sparta.myblog.domain;

import lombok.Getter;

@Getter
public class BoardRequestDto {

    private String title;
    private String username;
    private String contents;
    // 작성 날짜는?
}