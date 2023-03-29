package ramos.monteiro.alex.figurinhas.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ramos.monteiro.alex.figurinhas.entity.Figurinha;
import ramos.monteiro.alex.figurinhas.model.PacoteFigurinha;
import ramos.monteiro.alex.figurinhas.repository.FigurinhaRepository;
import ramos.monteiro.alex.figurinhas.service.FigurinhaService;

@Service
public class FigurinhaServiceImpl implements FigurinhaService {

	@Autowired
	private FigurinhaRepository repository;

	@Override
	public List<Figurinha> gerarFigurinhas(String albumId) {

		List<Figurinha> figurinhas = this.gerador(albumId);
		repository.saveAll(figurinhas);
		return figurinhas;

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
