package org.file.foto.file;

import org.file.foto.utils.GenericService;
import org.file.foto.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.FILE_PATH)
public class FileService extends GenericService<File, Long> {

	GuardarFotoNaPastaDados output = new GuardarFotoNaPastaDados();

	@Override
	public File insert(@RequestBody File file) {

		output.SalvarFotoNoDiretorioDados(file);
		return super.insert(file);

	}

}
