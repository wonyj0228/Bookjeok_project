package com.myproject.bookjeok_project.repository;

import com.myproject.bookjeok_project.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findByEmail(String email);
    UserAccount findByNickname(String nickname);
}
