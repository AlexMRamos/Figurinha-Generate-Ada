package ramos.monteiro.alex.figurinhas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class FigurinhaGenerateApplication {

	public static void main(String[] args) {
		SpringApplication.run(FigurinhaGenerateApplication.class, args);
	}

}
