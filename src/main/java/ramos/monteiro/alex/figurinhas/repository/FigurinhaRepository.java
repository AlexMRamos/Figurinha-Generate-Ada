package ramos.monteiro.alex.figurinhas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ramos.monteiro.alex.figurinhas.entity.Figurinha;

@Repository
public interface FigurinhaRepository extends MongoRepository<Figurinha, String>{

}
