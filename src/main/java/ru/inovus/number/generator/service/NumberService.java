package ru.inovus.number.generator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.inovus.number.generator.model.Number;
import ru.inovus.number.generator.repository.NumberRepository;

@Component
public class NumberService {

    @Autowired
    NumberRepository repository;

    private Number current = null;

    @Transactional
    public String random() {
        Number random = repository.findRandom();
        if (random != null) {
            current = random;
            repository.issueNumber(random.getId());
            return random.getNumberString();
        } else {
            return null;
        }
    }

    @Transactional
    public String next() {

        Number next;
        if (current != null) {
            next = repository.findNext(current.getNumOrder());
        } else {
            next = repository.findFirst();
        }
        if (next != null) {
            current = next;
            repository.issueNumber(next.getId());
            return next.getNumberString();
        } else {
            return null;
        }
    }
}
