package codingexam.grid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "codingexam.*")
public class GridProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GridProjectApplication.class, args);
	}
}
