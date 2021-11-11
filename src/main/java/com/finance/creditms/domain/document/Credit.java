package com.finance.creditms.domain.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@ToString
@Document(collection = "credit")
public class Credit {
    @Id
    private String id;
    private Client client;
    private String account;
    private Product product;
    private Double interestRate;
    private Integer term;
    private Integer numberFees;
    private double balance;
    private String currency;
    private boolean status = true;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cancelAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastMovement;

    public Credit(Client client, String account, Product product, Double interestRate, Integer term, Integer numberFees, double balance, String currency, boolean status, Date createAt, Date cancelAt, Date lastMovement) {
        this.client = client;
        this.account = account;
        this.product = product;
        this.interestRate = interestRate;
        this.term = term;
        this.numberFees = numberFees;
        this.balance = balance;
        this.currency = currency;
        this.status = status;
        this.createAt = createAt;
        this.cancelAt = cancelAt;
        this.lastMovement = lastMovement;
    }
}
