package com.myproject.bookjeok_project.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(unique = true, nullable = false) private String email;
    @Setter @Column(nullable = false) private String userPassword;
    @Setter @Column(nullable = false, length = 100) private String name;
    @Setter @Column(unique = true, nullable = false, length = 100) private String nickname;


    private UserAccount (String email, String userPassword, String name, String nickname) {
        this.email = email;
        this.userPassword = userPassword;
        this.name = name;
        this.nickname = nickname;
    }

    public static UserAccount of (String email, String userPassword, String name, String nickname) {
        return new UserAccount(email, userPassword, name, nickname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
