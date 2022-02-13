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

    private static final char[] letters = new char[]{'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    /**
     * Заполняет БД автомобильными номерами.
     * <p>
     * Заполняет БД автомобильными номерами.
     * Запускается только при запуске с профилем "warmup". Если в таблице уже есть записи, то ничего не делает.
     *
     * @param repository интерфес взаимодействия с таблицей автомобильных номеров
     * @return
     */
    @Profile("warmup")
    @Bean
    protected CommandLineRunner initDatabase(NumberRepository repository) {
        return args -> {
            if (!repository.findAll().iterator().hasNext()) {
                int order = 0;
                long start = System.currentTimeMillis();
                log.info("Warmup started");
                for (int l1 = 0; l1 < 12; l1++) {
                    for (int l2 = 0; l2 < 12; l2++) {
                        for (int l3 = 0; l3 < 12; l3++) {
                            List<Number> numbers = new ArrayList<>(1000);
                            for (int n = 0; n < 1000; n++) {
                                String numbersString = String.format("%03d", n);
                                StringBuilder number = new StringBuilder()
                                        .append(letters[l1]).append(numbersString).append(letters[l2]).append(letters[l3]);
                                numbers.add(new Number(number.toString(), "116 RUS", order, false));
                                order++;
                            }
                            repository.saveAll(numbers);
                        }
                    }
                }
                log.info(String.format("Warmup finished in %d sec", (System.currentTimeMillis() - start) / 1000));
            }
        };
    }
}