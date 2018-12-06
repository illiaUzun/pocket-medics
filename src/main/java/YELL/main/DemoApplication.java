package YELL.main;

import YELL.main.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context
//				= new AnnotationConfigApplicationContext(AppConfig.class);
		SpringApplication.run(DemoApplication.class, args);

	}
}