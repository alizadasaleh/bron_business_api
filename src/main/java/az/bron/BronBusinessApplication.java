package az.bron;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement
@EnableAsync
@MapperScan(basePackages = "az.bron.business.feature.staff.infrastruture.persistence")
public class BronBusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BronBusinessApplication.class, args);
    }
}