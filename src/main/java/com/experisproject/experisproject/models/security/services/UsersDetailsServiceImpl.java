package com.experisproject.experisproject.models.security.services;

import com.experisproject.experisproject.models.entities.Users;
import com.experisproject.experisproject.models.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsersDetailsServiceImpl implements UserDetailsService {
		@Autowired
		UsersRepository usersRepository;

		@Override
		@Transactional
		public UserDetails loadUserByUsername(String userName)
				throws UsernameNotFoundException {

			Users users = usersRepository.findByUserName(userName)
					.orElseThrow(() ->
							new UsernameNotFoundException("User Not Found with -> username or email : " + userName)
					);

			return UsersPrinciple.build(users);
		}

}
