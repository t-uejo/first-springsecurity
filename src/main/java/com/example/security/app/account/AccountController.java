package com.example.security.app.account;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.security.domain.model.Account;
import com.example.security.domain.service.userdetails.SampleUserDetails;



@Controller
@RequestMapping("account")
public class AccountController {
	@GetMapping
    public String showAccount(
    		@AuthenticationPrincipal SampleUserDetails userDetails,
    		Model model) {
		
		Account account = userDetails.getAccount();
        model.addAttribute(account);
        return "account/view";
	}
}
