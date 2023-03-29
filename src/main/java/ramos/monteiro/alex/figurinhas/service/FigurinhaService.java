package ramos.monteiro.alex.figurinhas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ramos.monteiro.alex.figurinhas.entity.Figurinha;
import ramos.monteiro.alex.figurinhas.model.PacoteFigurinha;


public interface FigurinhaService {
	
	
	List<Figurinha> gerarFigurinhas(String albumId);
	
	PacoteFigurinha gerarPacoteFigurinha();

}
