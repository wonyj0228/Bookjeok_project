package com.myproject.bookjeok_project.service;

import com.myproject.bookjeok_project.domain.UserAccount;
import com.myproject.bookjeok_project.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccount saveAccount(UserAccount userAccount) {
        ValidateDuplicateEmail(userAccount);

        return userAccountRepository.save(userAccount);
    }

    private void ValidateDuplicateEmail(UserAccount userAccount) {
        UserAccount findAccount = userAccountRepository.findByEmail(userAccount.getEmail());
        if (findAccount != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
