package ramos.monteiro.alex.figurinhas.service.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ramos.monteiro.alex.figurinhas.entity.Figurinha;
import ramos.monteiro.alex.figurinhas.kafka.producer.TopicProducer;
import ramos.monteiro.alex.figurinhas.model.PacoteFigurinha;
import ramos.monteiro.alex.figurinhas.model.ProduceForAlbum;
import ramos.monteiro.alex.figurinhas.repository.FigurinhaRepository;
import ramos.monteiro.alex.figurinhas.service.FigurinhaService;

@Service
public class FigurinhaServiceImpl implements FigurinhaService {

	@Autowired
	private FigurinhaRepository repository;
	
	@Autowired
	private TopicProducer producer;

	private String kafka = null;
	
	Gson gson = new Gson();
	
	@Override
	public List<Figurinha> gerarFigurinhas(String albumId) {
		
		ProduceForAlbum message = new ProduceForAlbum();
		message.setAlbumId(albumId);
		message.setStatus(false);

		try {
			List<Figurinha> figurinhas = this.gerador(albumId);
			repository.saveAll(figurinhas);
			
			message.setStatus(true);
			message.setMessage("Criado com Sucesso");
			
			
			this.kafka = gson.toJson(message);

			return figurinhas;
			
		} catch (Exception e) {
			message.setMessage("Erro na criação do Album: " + e.getMessage());
			kafka = gson.toJson(message);
			throw new RuntimeException(e);
		}finally {
			producer.send(kafka);
		}

	}

	@Override
	public PacoteFigurinha gerarPacoteFigurinha() {
		
		PacoteFigurinha pacote = this.geradorPacote();	
		return pacote;
	}

	private List<Figurinha> gerador(String albumId) {

		Gson gson = new Gson();

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("figurinhas-gerador/figurinhas.json");
		Reader reader = new InputStreamReader(inputStream);

		Type listType = new TypeToken<List<Figurinha>>() {
		}.getType();
		List<Figurinha> figurinhas = gson.fromJson(reader, listType);

		figurinhas.forEach(f -> f.setAlbumID(albumId));
		return figurinhas;

	}
	
	private PacoteFigurinha geradorPacote(){

		Gson gson = new Gson();

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("figurinhas-gerador/pacote-figurinha.json");
		Reader reader = new InputStreamReader(inputStream);


		PacoteFigurinha pacote = gson.fromJson(reader, PacoteFigurinha.class);

		
		return pacote;

	}

}
