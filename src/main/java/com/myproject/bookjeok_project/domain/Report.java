package com.myproject.bookjeok_project.domain;

import java.time.LocalDateTime;

public class Report {
    private Long id;

    private Long userAccountId;
    private Long bookId;
    private String title;
    private float rate;
    private String content;

    private String createdBy;
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;
}
