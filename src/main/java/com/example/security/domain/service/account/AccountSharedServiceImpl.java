package com.example.security.domain.service.account;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.example.security.domain.model.Account;
import com.example.security.domain.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountSharedServiceImpl implements AccountSharedService {
	private final AccountRepository accountRepository;
	
	@Transactional(readOnly = true)
	@Override
	public Account findOne(String username) {
        return accountRepository.findById(username)
        		.orElseThrow(() -> {
		            ResultMessages messages = ResultMessages.error();
		            messages.add(ResultMessage.fromText(
		                    "The given account is not found! username=" + username));
		            return new ResourceNotFoundException(messages);
		        });
	}

}
