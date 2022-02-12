package ru.inovus.number.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import ru.inovus.number.generator.model.Number;
import ru.inovus.number.generator.repository.NumberRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StartApplication {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    // run this only on profile 'demo', avoid run this in test
    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(NumberRepository repository) {
        return args -> {
            if(!repository.findAll().iterator().hasNext()) {
                char[] letters = new char[]{'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
                int order = 0;
                long start = System.currentTimeMillis();
                log.info("Warmup started");
                for (int l1 = 0; l1 < 12; l1++) {
                    for (int l2 = 0; l2 < 12; l2++) {
                        for (int l3 = 0; l3 < 12; l3++) {
                            List<Number> numbers = new ArrayList<>();
                            for (int n = 0; n < 1000; n++) {
                                String numbersString = String.format("%03d", n);
                                numbers.add(new Number((letters[l1] + numbersString + letters[l2] + letters[l3]), "116 RUS", order, false));
                                order++;
                            }
                            repository.saveAll(numbers);
                        }
                    }
                }
                log.info("Warmup finished in " + (System.currentTimeMillis() - start) / 1000 + " sec");
            }
        };
    }
}