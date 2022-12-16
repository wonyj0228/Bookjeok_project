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
        return userAccountRepository.save(userAccount);
    }

    public String validateDuplicateEmail(UserAccount userAccount) {
        UserAccount findAccount = userAccountRepository.findByEmail(userAccount.getEmail());
        if (findAccount != null) {
            return "1";
        } else {
            return "2";
        }
    }
    public String validateDuplicateNickname(UserAccount userAccount) {
        UserAccount findAccount = userAccountRepository.findByNickname(userAccount.getNickname());
        if (findAccount != null) {
            return "3";
        } else {
            return "4";
        }
    }
}
