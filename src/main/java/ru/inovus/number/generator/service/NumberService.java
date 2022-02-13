package ru.inovus.number.generator.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.inovus.number.generator.error.NumbersIsOverException;
import ru.inovus.number.generator.model.Number;
import ru.inovus.number.generator.repository.NumberRepository;

/**
 * Сервис для получения автомобильных номеров
 */
@Component
public class NumberService {

    private final NumberRepository repository;

    public NumberService(NumberRepository repository) {
        this.repository = repository;
    }

    private Number current = null;

    /**
     * Выдает случайный автомобильный номер. В случае, если намера закончились, выбрасывает NumbersIsOverException
     *
     * @return
     */
    @Transactional
    synchronized public Number random() {
        Number random = repository.findRandom();
        if (random != null) {
            current = random;
            repository.issueNumber(random.getId());
            return random;
        } else {
            throw new NumbersIsOverException();
        }
    }

    /**
     * Выдает следующий за последним выданным автомобильный номер.  В случае, если намера закончились, выбрасывает NumbersIsOverException
     *
     * @return
     */
    @Transactional
    synchronized public Number next() {
        Number next;
        if (current != null) {
            next = repository.findNext(current.getNumOrder());
        } else {
            next = repository.findFirst();
        }
        if (next != null) {
            current = next;
            repository.issueNumber(next.getId());
            return next;
        } else {
            throw new NumbersIsOverException();
        }
    }
}
