package tacos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.stream.Stream;

@SpringBootApplication
public class TacoCloudApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        Stream.of(beanDefinitionNames).forEach(beanName->{
            System.out.println("beanName : " + beanName);

            Object bean = applicationContext.getBean(beanName);

            System.out.println("Spring bean : " + bean);
        });

    }

}
