package com.example.security.domain.service.userdetails;

import jakarta.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import com.example.security.domain.service.account.AccountSharedService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleUserDetailsService implements UserDetailsService {

	private final AccountSharedService accountSharedService;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		try {
			return new SampleUserDetails(accountSharedService.findOne(username));
			
		} catch (ResourceNotFoundException e) {
			throw new UsernameNotFoundException("user not found", e);
		}
	}

}
