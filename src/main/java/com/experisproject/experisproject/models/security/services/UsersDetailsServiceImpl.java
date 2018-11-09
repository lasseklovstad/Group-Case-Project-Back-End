package com.experisproject.experisproject.models.security.services;

import com.experisproject.experisproject.models.entities.Users;
import com.experisproject.experisproject.models.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersDetailsServiceImpl implements UserDetailsService {

	UsersRepository usersRepository;

	@Autowired
	public UsersRepository usersRepository(UsersRepository usersRepository) {
		return this.usersRepository = usersRepository;
	}

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

	public List<Users> findAll() {
		List<Users> result = new ArrayList<>();
		usersRepository.findAll().forEach(users -> result.add(users));
		return result;
	}

	public List<Users> findUsersIdUsernameEmail(){
		return usersRepository.findUsersIdUsernameEmail();
	}

	public Users findByEmail(String email){
		return usersRepository.findByEmail(email);
	}

	public Users findById(int id) {
		return usersRepository.findById(id).get();
	}

	public  void deleteById(int id){
		usersRepository.deleteById(id);
	}
	public Boolean existsByEmail(String email){
		return usersRepository.existsByEmail(email);
	}

	public void updateUsers(Users users){
		save(users);
	}
	public void save(Users users) {
		usersRepository.save(users);
	}

	public int findUserIdByUserName(String userName){
		return usersRepository.findUsers_userIdByUserName(userName);
	}

}
