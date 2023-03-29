package ramos.monteiro.alex.figurinhas.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
