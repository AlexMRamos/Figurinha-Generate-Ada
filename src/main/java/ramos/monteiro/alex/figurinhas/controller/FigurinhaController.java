package ramos.monteiro.alex.figurinhas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ramos.monteiro.alex.figurinhas.entity.Figurinha;
import ramos.monteiro.alex.figurinhas.service.impl.FigurinhaServiceImpl;

@RestController
@RequestMapping("/figurinha")
public class FigurinhaController {
	
	@Autowired
	private FigurinhaServiceImpl service;
	
	@PostMapping("/gerar-figurinha")
    public ResponseEntity<List<Figurinha>> findById(@RequestParam("id") String albumId) {
            return ResponseEntity.ok(service.gerarFigurinhas(albumId));

        }	
	
	
	
	

}
