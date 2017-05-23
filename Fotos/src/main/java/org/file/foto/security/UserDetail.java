package org.file.foto.security;

import org.file.foto.permission.PermissionEntity;
import org.file.foto.user.UserEntity;
import org.file.foto.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetail implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity user = this.userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("User with email \"" + email + "\" was not found");
		}

		LoginDetailBean login = new LoginDetailBean(user.getName(), user.getEmail(), user.getPassword());

		for (PermissionEntity permission : user.getPermissions()) {
			login.addRole(permission.getRole());
		}

		return login;
	}

}
