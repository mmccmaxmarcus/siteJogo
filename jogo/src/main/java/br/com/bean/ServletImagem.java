package br.com.bean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.models.ImagemModel;

import entities.Imagem;

@SuppressWarnings("serial")
@WebServlet("/image")
public class ServletImagem extends HttpServlet {
	private String imagemPath;
	private ImagemModel getImagemModel() {
		ImagemModel imagemModel = new ImagemModel();
		return imagemModel;
	}
	
	public void init() throws ServletException {
		this.imagemPath = "/home/gemel/eclipse-workspace/jogo/src/main/webapp/resources/images/";
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String requestedImage = req.getParameter("imagem");
		File image = new File(imagemPath,requestedImage);
		String contentType = getServletContext().getMimeType(image.getName());
		
		resp.reset();
		resp.setContentType(contentType);
		resp.setHeader("Content-Length", String.valueOf(image.length()));
		Files.copy(image.toPath(), resp.getOutputStream());
	}
}
