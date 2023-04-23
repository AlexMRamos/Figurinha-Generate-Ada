package ramos.monteiro.alex.figurinhas.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "figurinha")
public class Figurinha {
	
	@Id
	private String id;
	
	private String imagem;
	
	private String descricao;
	
	private String raridade;
	
	private Double preco;
	
	@NotEmpty
	private String albumID;
	

}
