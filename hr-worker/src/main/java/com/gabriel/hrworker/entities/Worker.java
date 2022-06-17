package com.gabriel.hrworker.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_worker")
public class Worker  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double dailyIncome;

}
