package org.file.foto;

import org.file.foto.utils.AppContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppMain {

	public static void main(String[] args) {
		SpringApplication.run(AppContext.class, args);
	}

}
