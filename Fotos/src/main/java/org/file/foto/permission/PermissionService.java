package org.file.foto.permission;

import org.file.foto.utils.GenericService;
import org.file.foto.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.PERMISSION_PATH)
public class PermissionService extends GenericService<PermissionEntity, Long> {

}
