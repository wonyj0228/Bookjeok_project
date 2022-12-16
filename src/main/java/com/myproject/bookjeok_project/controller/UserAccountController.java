package com.myproject.bookjeok_project.controller;


import com.myproject.bookjeok_project.domain.UserAccount;
import com.myproject.bookjeok_project.dto.UserAccountDto;
import com.myproject.bookjeok_project.service.UserAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/sign-up")
    public String view(Model model) {
        model.addAttribute("userAccountDto", new UserAccountDto()); //입력폼을 위한 빈 dto를 전달
        return "signUp";
    }

    @PostMapping("/sign-up")
    public String signUp(@Valid UserAccountDto userAccountDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signUp";
        }
        try {
            UserAccount account = UserAccount.createAccount(userAccountDto, passwordEncoder);
            UserAccount savedAccount = userAccountService.saveAccount(account);

        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "signUp";
        }

        return "redirect:/";
    }

    @PostMapping("/sign-up/check")
    @ResponseBody
    public String duplicateCheck(@RequestBody UserAccount userAccount) {
        if (userAccount.getEmail() != null) {
            return userAccountService.validateDuplicateEmail(userAccount);
        } else if (userAccount.getNickname() != null) {
            return userAccountService.validateDuplicateNickname(userAccount);
        }
        return "";
    }

}
