package com.gabriel.hrpayroll.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {
    private String name;
    private Double dailyIncome;
    private Integer days;

    public Double getTotal(){
        return days * dailyIncome;
    }
}
