package view;

import java.io.File;
import java.io.IOException;

import controller.ArquivosController;
import interfaces.IArquivosController;

public class Main {

	public static void main(String[] args) {
		String path = new File("").getAbsolutePath() + "\\Arquivos";
		String nome = "relatorio";
		IArquivosController sla = new ArquivosController();
		try {
			sla.convertArq(path, nome);
			sla.openFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
