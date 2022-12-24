package tp.discovery.eurekadicovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDicoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaDicoveryApplication.class, args);
    }

}
