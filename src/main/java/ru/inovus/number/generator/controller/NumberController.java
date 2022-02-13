package ru.inovus.number.generator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inovus.number.generator.service.NumberService;

/**
 * REST-сервис для получения случайного и следущего автомобильного номера
 */
@RestController
@RequestMapping("number")
public class NumberController {

    private final NumberService service;

    public NumberController(NumberService service) {
        this.service = service;
    }

    /**
     * Запрашивает случайный автомобильный номер
     *
     * @return Автомобильный номер в Формате "А000АА 116 RUS"
     */
    @GetMapping("/random")
    String random() {
        return service.random().getNumberString();
    }

    /**
     * Запрашивает следующий за последним выданным автомобильный номер
     *
     * @return Автомобильный номер в Формате "А000АА 116 RUS"
     */
    @GetMapping("/next")
    String next() {
        return service.next().getNumberString();
    }

}
