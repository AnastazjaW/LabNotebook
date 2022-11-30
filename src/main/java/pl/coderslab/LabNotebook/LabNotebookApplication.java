package pl.coderslab.LabNotebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class LabNotebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabNotebookApplication.class, args);
	}

}
