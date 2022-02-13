package ru.inovus.number.generator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Автомобильный номер
 */
@Entity
public class Number {


    @Id
    @GeneratedValue
    private Long id;
    private String number;
    private String series;
    private Integer numOrder;
    private Boolean issued;

    /**
     * Создает пустой автомобильный номер
     */
    public Number() {
    }

    /**
     * Создает ноывй автомобильный номер с указанными параметрами
     *
     * @param id       идентификатор записи
     * @param number   численно-буквенная часть автомобильного номера
     * @param series   серия автомобильного номера
     * @param numOrder порядковое значение автомобильного номера в разрезе серии
     * @param issued   признак, показывающий, был ли автомобильный номер выдан
     */
    public Number(Long id, String number, String series, Integer numOrder, Boolean issued) {
        this.id = id;
        this.number = number;
        this.series = series;
        this.numOrder = numOrder;
        this.issued = issued;
    }

    /**
     * Создает ноывй автомобильный номер с указанными параметрами
     *
     * @param number   численно-буквенная часть автомобильного номера
     * @param series   серия автомобильного номера
     * @param numOrder порядковое значение автомобильного номера в разрезе серии
     * @param issued   признак, показывающий, был ли автомобильный номер выдан
     */
    public Number(String number, String series, Integer numOrder, Boolean issued) {
        this.number = number;
        this.series = series;
        this.numOrder = numOrder;
        this.issued = issued;
    }

    /**
     * Возвращает идентификатор записи
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор записи
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Возвращает численно-буквеннаю часть автомобильного номера
     *
     * @return
     */
    public String getNumber() {
        return number;
    }

    /**
     * Устанавливает численно-буквеннаю часть автомобильного номера
     *
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Возвращает серию автомобильного номера
     *
     * @return
     */
    public String getSeries() {
        return series;
    }

    /**
     * Устанавливает серию автомобильного номера
     *
     * @param series
     */
    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * Возвращает порядковое значение автомобильного номера в разрезе серии
     *
     * @return
     */
    public Integer getNumOrder() {
        return numOrder;
    }

    /**
     * Устанавливает порядковое значение автомобильного номера в разрезе серии
     *
     * @param numOrder
     */
    public void setNumOrder(Integer numOrder) {
        this.numOrder = numOrder;
    }

    /**
     * Возвращает, был ли автомобильный номер выдан
     *
     * @return
     */
    public Boolean getIssued() {
        return issued;
    }

    /**
     * Устанавливает, был ли автомобильный номер выдан
     *
     * @param issued
     */
    public void setIssued(Boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", series='" + series + '\'' +
                ", order=" + numOrder +
                ", issued=" + issued +
                '}';
    }

    /**
     * Возвращает текстовое значение автомобильного номера в формате "А000АА 116 RUS"
     *
     * @return
     */
    public String getNumberString() {
        return number + " " + series;
    }
}
