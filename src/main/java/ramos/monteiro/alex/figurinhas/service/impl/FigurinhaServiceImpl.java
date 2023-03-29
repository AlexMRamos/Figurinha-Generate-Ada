package ramos.monteiro.alex.figurinhas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		List<Figurinha> lista = new ArrayList<>();
		Figurinha f = Figurinha.builder().AlbumID(albumId).descricao("desc 1").imagem("img 1").raridade("1").preco(22.2d).build();
		
		lista.add(f);
		
		
		repository.save(f);
		
		return lista;
	}

	@Override
	public List<PacoteFigurinha> gerarPacoteFigurinha(String albumId) {
		// TODO Auto-generated method stub
		return null;
	}

}
