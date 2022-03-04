package br.edu.iftm.SmartSchool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.jdbc.core.JdbcTemplate;

import br.edu.iftm.SmartSchool.repository.SecretariaRepository;

@SpringBootApplication
public class SmartSchoolApplication implements CommandLineRunner{
	@Autowired
	SecretariaRepository admin;
	public static void main(String[] args) {
		SpringApplication.run(SmartSchoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			admin.gravaSecretaria();
		} catch (Exception e) {
			System.out.println("----------------------------");
		}
	}
}
