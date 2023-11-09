package tn.iit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tn.iit.bean.HelloBean;


@SpringBootApplication
public class FirstSpringBootApplication implements CommandLineRunner {

	@Autowired
	private HelloBean h;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("test passed");
	}

}
