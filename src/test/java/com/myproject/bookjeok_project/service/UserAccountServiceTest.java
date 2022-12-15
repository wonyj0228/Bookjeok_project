package com.myproject.bookjeok_project.service;

import com.myproject.bookjeok_project.domain.UserAccount;
import com.myproject.bookjeok_project.dto.UserAccountDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
class UserAccountServiceTest {

    @Autowired UserAccountService userAccountService;
    @Autowired PasswordEncoder passwordEncoder;

    @DisplayName("dto로 데이터 받아서 domain으로 계정 생성")
    public UserAccount createDomainUserAccount() {
        UserAccountDto account1 = UserAccountDto.builder()
                .email("yejin@email.com")
                .userPassword("1122")
                .name("테스트")
                .nickname("imTest")
                .build();

        return UserAccount.createAccount(account1, passwordEncoder);
    };

    @DisplayName("[회원가입] 생성된 domaim 데이터 저장 테스트")
    @Test
    void saveUserAccount() {
        UserAccount account = createDomainUserAccount();
        UserAccount savedAccount = userAccountService.saveAccount(account);

        assertThat(savedAccount).isEqualTo(account);
    }
}