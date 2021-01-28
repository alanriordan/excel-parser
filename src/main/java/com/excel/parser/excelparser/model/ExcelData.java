package com.excel.parser.excelparser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "ExcelData")

public class ExcelData {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "RATE_VALUE")
    private Integer rateValue;

    @Column(name = "LIMITS")
    private Integer limits;

    @Column(name = "AI")
    private Integer ai;

    public ExcelData(Integer rateValue, Integer limits, Integer ai) {
        this.rateValue = rateValue;
        this.limits = limits;
        this.ai = ai;
    }

    public ExcelData() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getRateValue() {
        return rateValue;
    }

    public void setRateValue(Integer rateValue) {
        this.rateValue = rateValue;
    }

    public Integer getLimits() {
        return limits;
    }

    public void setLimits(Integer limits) {
        this.limits = limits;
    }

    public Integer getAi() {
        return ai;
    }

    public void setAi(Integer ai) {
        this.ai = ai;
    }
}
