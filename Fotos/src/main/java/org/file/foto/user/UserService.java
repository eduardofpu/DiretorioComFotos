package org.file.foto.user;

import org.file.foto.utils.GenericService;
import org.file.foto.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.USER_PATH)
public class UserService extends GenericService<UserEntity, Long> {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserEntity insert(@RequestBody UserEntity user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		return super.insert(user);
	}

	@Override
	public void update(@RequestBody UserEntity user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		super.update(user);
	}

}
