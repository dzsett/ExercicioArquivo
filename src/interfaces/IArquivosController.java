package interfaces;

import java.io.IOException;

public interface IArquivosController {
	public void convertArq(String path, String nome) throws IOException;
	public void openFile(String path, String nome) throws IOException;
}
