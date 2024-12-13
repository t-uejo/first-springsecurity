package com.example.security.domain.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.security.domain.model.Account;

@Mapper
public interface AccountRepository {
	@Select("""
			SELECT
				username,
	            password,
	            first_name,
	            last_name
	        FROM
	            account
	        WHERE
	            username = #{username};
			""")
	Optional<Account> findById(@Param("username") String username);
}
