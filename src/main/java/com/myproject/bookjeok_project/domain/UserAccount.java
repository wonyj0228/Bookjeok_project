package com.myproject.bookjeok_project.domain;


import com.myproject.bookjeok_project.dto.UserAccountDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    // static method = class domain 객체가 생성되어 있지않아도 class명.method 로 해당 메서드를 호출할 수 있다.
    // 일반 메서드 = domian객체명.method임
    public static UserAccount createAccount(UserAccountDto userAccountDto, PasswordEncoder passwordEncoder) {
        return new UserAccount(
                userAccountDto.getEmail(),
                passwordEncoder.encode(userAccountDto.getUserPassword()),
                userAccountDto.getName(),
                userAccountDto.getNickname()
        );
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
