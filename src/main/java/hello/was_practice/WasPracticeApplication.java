package hello.was_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
// GET -> calculate?operand1=11&operateor=*&operand2=55
public class WasPracticeApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WasPracticeApplication.class, args);
		new CustomWebApplicationServer(8081).start();
	}

}
