package makaza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MakazaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MakazaApplication.class, args);
		System.out.println("Hello world!");
	}
}
