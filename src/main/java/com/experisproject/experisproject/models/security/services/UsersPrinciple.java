package com.experisproject.experisproject.models.security.services;

import com.experisproject.experisproject.models.entities.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UsersPrinciple implements UserDetails {

		private static final long serialVersionUID = 1L;

		private int userId;

		private String userName;

		private String email;

		@JsonIgnore
		private String password;

		private Collection<? extends GrantedAuthority> authorities;

		public UsersPrinciple(int userId, String userName, String email, String password,
							 Collection<? extends GrantedAuthority> authorities) {
			this.userId = userId;
			this.userName = userName;
			this.email = email;
			this.password = password;
			this.authorities = authorities;
		}

		public static UsersPrinciple build(Users user) {
			List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
					new SimpleGrantedAuthority(role.getName().name())
			).collect(Collectors.toList());

			return new UsersPrinciple(
					user.getUserId(),
					user.getUserName(),
					user.getEmail(),
					user.getPassword(),
					authorities
			);
		}

		public int getUserId() {
			return userId;
		}

		public String getEmail() {
			return email;
		}

		@Override
		public String getUsername() {
			return userName;
		}

		@Override
		public String getPassword() {
			return password;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			UsersPrinciple user = (UsersPrinciple) o;
			return Objects.equals(userId, user.userId);
		}

}
