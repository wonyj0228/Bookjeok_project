package com.myproject.bookjeok_project.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long id;

    private Long userAccountId;

    private String content;
    private int like;

    private String createdBy;
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;
}
