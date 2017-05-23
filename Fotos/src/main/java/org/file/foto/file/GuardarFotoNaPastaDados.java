package org.file.foto.file;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GuardarFotoNaPastaDados {



	public void SalvarFotoNoDiretorioDados(File file){
		Diretorio diretorio = new Diretorio();
		diretorio.CriarDiretorio();

		try(BufferedOutputStream insert = new BufferedOutputStream(
				new FileOutputStream("Dados/" + file.getNomeImage() + ".jpeg"), 4098)){
			insert.write(file.getFile());
			insert.flush();
			System.out.println("Nome da image :" + file.getNomeImage());
			System.out.println("Pasta Dados obteve uma foto com sucesso!");

		}catch(
				IOException e)
		{
			e.printStackTrace();
			System.out.println("Error Ao Gravar a foto para pasta Dados!");
		}
	}
}
