package com.devsuperior.hrpayroll.entities;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionID = 1L;

    private String name;
    private Double dailyIncome;
    private Integer days;

    public Double getTotal() {
        return this.days * this.dailyIncome;
    }
}
