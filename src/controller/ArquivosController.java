package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import interfaces.IArquivosController;

public class ArquivosController implements IArquivosController {
	
	public ArquivosController() {
		super();
	}

	@Override
	public void convertArq(String path, String nome) throws IOException {
		File file = new File(path, nome + ".txt");
		if (file.exists() && file.isFile()) {
			FileInputStream flow = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			String coisado = line + "\n";
			while(line!=null) {
				line = buffer.readLine();
				if(line!=null) { 
					String [] coisas = line.split(" ");
					for(String coisa : coisas) {
						coisado += coisa + ";";
					}
					coisado+= " ";
					coisado+="\n";
				}
			}
			create(coisado, path, nome);
			buffer.close();
			reader.close();
			flow.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}
	
	private void create(String coisado, String path, String n) throws IOException {
		String nome = n + ".csv";
		File dir = new File(path);
		File arq = new File(path, nome);
		if (dir.exists() && dir.isDirectory()) {
			FileWriter fileWriter = new FileWriter(arq);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.write(coisado);
			printWriter.flush();
			printWriter.close();
			fileWriter.close();
		}else {
			throw new IOException("Arquivo Inválido");
		}
	}

	@Override
	public void openFile(String path, String nome) throws IOException {
		File arq = new File(path, nome + ".csv");
		if (arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}

}
