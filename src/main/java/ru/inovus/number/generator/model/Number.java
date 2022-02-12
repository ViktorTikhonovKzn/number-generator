package ru.inovus.number.generator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Number {
    @Id
    @GeneratedValue
    private Long id;
    private String number;
    private String series;
    private Integer numOrder;
    private Boolean issued;

    public Number() {
    }

    public Number(Long id, String number, String series, Integer numOrder, Boolean issued) {
        this.id = id;
        this.number = number;
        this.series = series;
        this.numOrder = numOrder;
        this.issued = issued;
    }

    public Number(String number, String series, Integer numOrder, Boolean issued) {
        this.number = number;
        this.series = series;
        this.numOrder = numOrder;
        this.issued = issued;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getNumOrder() {
        return numOrder;
    }

    public void setNumOrder(Integer numOrder) {
        this.numOrder = numOrder;
    }

    public Boolean getIssued() {
        return issued;
    }

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

    public String getNumberString() {
        return number + " " + series;
    }
}
