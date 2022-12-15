package com.myproject.bookjeok_project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@Getter
@Setter
public class UserAccountDto {

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String userPassword;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    @Length(min = 2, max = 20, message = "닉네임은 2자 이상, 20자 이하로 입력해주세요.")
    private String nickname;

    @Builder
    public UserAccountDto(String email, String userPassword, String name, String nickname) {
        this.email = email;
        this.userPassword = userPassword;
        this.name = name;
        this.nickname = nickname;
    }
}
