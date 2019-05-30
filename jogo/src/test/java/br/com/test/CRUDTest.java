package br.com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.models.EspecificacaoModel;
import br.com.models.GeneroModel;
import br.com.models.GeneroTipoModel;
import br.com.models.IdiomaModel;
import br.com.models.ImagemModel;
import br.com.models.JogoModel;
import br.com.models.PlataformaModel;
import entities.Especificacao;
import entities.Genero;
import entities.GeneroTipo;
import entities.Idioma;
import entities.Imagem;
import entities.Jogo;
import entities.Plataforma;

public class CRUDTest {
	GeneroModel generoModel;
	IdiomaModel idiomaModel;
	PlataformaModel plataformaModel;
	JogoModel jogoModel;
	ImagemModel imagemModel;
	GeneroTipoModel generoTipoModel;
	EspecificacaoModel especificacaoModel;
	List<Especificacao> especificacoes;
	
	
	@Test
	@Ignore
	public void createEspecificacao() {
		especificacaoModel = new EspecificacaoModel();
		especificacoes = new ArrayList<>();
		especificacoes.add(
				new Especificacao(
						"Windows 7, 8, Windows 10 (64 bit)", 
						"Intel Core i5 3570, AMD FX-6350Intel Core i5 3570, AMD FX-6350", 
						"6 GB de RAM",
						"NVIDIA GTX 660 2GB, AMD Radeon 7850 2GB",
						"Versão 11", "15 GB de espaço disponível",
						"DirectX compatible Sound card"));
		
		especificacoes.add(
				new Especificacao(
						"Windows 7, 8, Windows 10 (64 bit)", 
						"Intel Core i5-3470 (3.2 GHz) / AMD A8-7600 (3.1 GHz)Intel Core i5-3470 (3.2 GHz) / AMD A8-7600 (3.1 GHz)", 
						"5 GB de RAM",
						"GeForce GTX 750 Ti / AMD Radeon R7 265",
						"Versão 11", "14 GB de espaço disponível",
						"DirectX compatible Sound card", 
						"Requires a 64-bit processor and operating system"));
		
		especificacoes.add(
				new Especificacao(
						"Windows XP (64Bit)", 
						"Core2Duo", 
						"3 GB de RAM",
						"Any with hardware 3D acceleration",
						"Versão 7.0", "4850 MB de espaço disponível",
						"Soundblaster / equivalenT"));
		
		for (Especificacao e : especificacoes) {
			especificacaoModel.save(e);
		}
		
		
	}

	@Test
	@Ignore
	public void createPlataforma() {

		Plataforma plataforma = new Plataforma("PS4");
		plataformaModel = new PlataformaModel();
		plataformaModel.save(plataforma);

	}
	
	@Test
	@Ignore
	public void createGeneroTipo() {
		generoTipoModel = new GeneroTipoModel();
		GeneroTipo generoTipo = new GeneroTipo("Luta");
		generoTipoModel.save(generoTipo);
	}

	@Test
	@Ignore
	public void createGenero() {
		jogoModel = new JogoModel();
		generoModel = new GeneroModel();
		generoTipoModel = new GeneroTipoModel();
		plataformaModel = new PlataformaModel();
		GeneroTipo generoTipo = generoTipoModel.find(4);
		Plataforma plataforma = plataformaModel.find(1);
		Jogo jogo = jogoModel.find(3);

		Genero genero = new Genero(jogo, plataforma, generoTipo);
		
		generoModel.save(genero);

	}

	@Test
	@Ignore
	public void createIdioma() {
		jogoModel = new JogoModel();
		Jogo jogo = jogoModel.find(3);
		Idioma idioma = new Idioma(" Multi (Inclui legendas e menus PTBR)", null, jogo);
		idiomaModel = new IdiomaModel();

		idiomaModel.save(idioma);

	}

	@Test
	@Ignore
	public void createGame() {
		jogoModel = new JogoModel();
		imagemModel = new ImagemModel();
		plataformaModel = new PlataformaModel();
		Imagem imagem = imagemModel.find(2);
		Plataforma plataforma = plataformaModel.find(1);
		Jogo jogo = new Jogo(new Date(), "1.80 GB", imagem, "ISO", true , "Vambrace: Cold Soul Torrent (2019) PC GAME Download",
				plataforma, new Date(), "Vambrace: Cold Soul é uma fantasia-aventura roguelike ambientada em meio a uma paisagem congelada. Planeje suas expedições no subsolo, depois viaje até a superfície da cidade amaldiçoada com sua equipe de heróis. Tenha poderes únicos, evite armadilhas perigosas, corajosos encontros estranhos e sobreviva a combates mortais!");
		jogoModel.save(jogo);
		

	}
	
	@Test
	@Ignore
	public void listGame() {
		List<Jogo> jogos = new ArrayList<Jogo>();
		jogoModel = new JogoModel();
		jogos = jogoModel.list();
 
		for (Jogo jogo : jogos) {
			System.out.println(jogo.getTituloJogo());
			System.out.println(jogo.getCrackIncluso());
			System.out.println(jogo.getTamanhoJogo());
			System.out.println("--------------------------------------------------------------------");
			for (Genero genero : jogo.getGeneros()) {
				System.out.println(genero.getTipoGenero().getTipoGenero());
				System.out.println(genero.getPlataforma().getTipoPlataforma());
			}
			System.out.println("--------------------------------------------------------------------");
			for (Idioma idioma : jogo.getIdiomas()) {
				System.out.println(idioma.getNomeIdioma());
			}
		}

	}
	
	

	@Test
	@Ignore
	public void buscaGeneros() {
		generoModel = new GeneroModel();
		plataformaModel = new PlataformaModel();
		List<String>generos = plataformaModel.buscarPorGenero(1);
		System.out.println(generos);
	}

}
