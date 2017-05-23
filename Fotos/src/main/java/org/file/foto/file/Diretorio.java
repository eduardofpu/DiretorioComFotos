package org.file.foto.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Diretorio {

	public Path CriarDiretorio(){
		Path path = Paths.get("Dados");

		try {
			if(Files.notExists(path))
				Files.createDirectory(path);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return path;
	}


}
