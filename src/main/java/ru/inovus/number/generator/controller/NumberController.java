package ru.inovus.number.generator.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inovus.number.generator.error.NumberNotFoundException;
import ru.inovus.number.generator.service.NumberService;

@RestController
public class NumberController {

    @Autowired
    private NumberService service;

    @GetMapping("/random")
    String random() {
        String randomNumber = service.random();
        if (StringUtils.isNotBlank(randomNumber)) {
            return randomNumber;
        } else {
            throw new NumberNotFoundException();
        }
    }

    @GetMapping("/next")
    String next() {
        String nextNumber = service.next();
        if (StringUtils.isNotBlank(nextNumber)) {
            return nextNumber;
        } else {
            throw new NumberNotFoundException();
        }
    }

}
