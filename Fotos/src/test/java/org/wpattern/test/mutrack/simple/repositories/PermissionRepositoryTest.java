package org.wpattern.test.mutrack.simple.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.file.foto.permission.PermissionEntity;
import org.file.foto.permission.PermissionRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.test.mutrack.simple.utils.AbstractTest;

public class PermissionRepositoryTest extends AbstractTest {

	private static final Logger LOGGER = Logger.getLogger(UserRepositoryTest.class);

	@Autowired
	private PermissionRepository permissionRepository;

	@Test
	public void findAllTest() {
		List<PermissionEntity> permissions = this.permissionRepository.findAll();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Test FindAll(): " + permissions);
		}
	}

}
