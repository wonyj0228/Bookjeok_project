package com.myproject.bookjeok_project.repository;

import com.myproject.bookjeok_project.domain.UserAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class UserAccountRepositoryTest {

    private final UserAccountRepository userAccountRepository;

    public UserAccountRepositoryTest(@Autowired UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }


    @DisplayName("계정 생성 테스트")
    @Test
    void givenNothing_whenSaveAccount_thenIsWorking() {
        userAccountRepository.save(UserAccount.of("yee@mail.com", "0101", "yejin", "yejiinee"));
        assertThat(userAccountRepository.findByEmail("yee@mail.com").getId())
                .isEqualTo(1L);

        System.out.println(userAccountRepository.findAll());
    }


}