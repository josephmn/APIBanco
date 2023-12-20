package com.banco.APIBanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//implements CommandLineRunner
@SpringBootApplication
public class ApibancoApplication {
	/*
	@Autowired
	private JdbcTemplate template;
	*/
	public static void main(String[] args) {
		SpringApplication.run(ApibancoApplication.class, args);
	}
	/*
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		template.execute("DROP TABLE tb_exchangerate IF EXISTS");
		template.execute("CREATE TABLE TB_EXCHANGERATE(ID BIGINT auto_increment PRIMARY KEY,SOURCE_CURRENCY NVARCHAR(255),TARGET_CURRENCY NVARCHAR(255),RATE DECIMAL(19, 4),CREATE_AT TIMESTAMP,UPDATE_AT TIMESTAMP)");

		//for (int i = 0; i < 3; i++) {
		template.execute("insert into TB_EXCHANGERATE(SOURCE_CURRENCY, TARGET_CURRENCY, RATE, CREATE_AT, UPDATE_AT) values ('SOL','DOL',3.67, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)");
		template.execute("insert into TB_EXCHANGERATE(SOURCE_CURRENCY, TARGET_CURRENCY, RATE, CREATE_AT, UPDATE_AT) values ('SOL','EUR',4.12, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)");
		//}
	}
	*/

}
