package com.unknown.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.unknown.dto.MyUser;
import com.unknown.entity.UsersEntity;
import com.unknown.repository.IUsersRepository;

//@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	IUsersRepository usersRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersEntity usersEntity = usersRepository.findOneByUserNameAndStatus(username, 1);
		if(usersEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(usersEntity.getRole().getCode()));
		MyUser myUser = new MyUser(usersEntity.getUserName(), usersEntity.getPassword(), true, true, true, true, authorities);
		myUser.setFullName(usersEntity.getFullName());
		return myUser;
	}

}
