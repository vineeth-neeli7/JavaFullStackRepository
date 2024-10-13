package vineeth.project.socialmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialmediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialmediaApplication.class, args);
	}

}


/* If port is in use then kill the process which was already there : Open Command promt : netstat -a -n -o | find "8080" 
 * then you get pid 
 * then open windos shell as administrator and kill :  taskkill /pid 4456 /f */ 