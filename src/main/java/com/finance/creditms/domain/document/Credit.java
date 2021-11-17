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
    private CreditCard creditCard;
    private Double interestRate;
    private double balance;
    private double lineCredit;
    private double initialLineCredit;
    private String currency;
    private boolean status = true;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cancelAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastMovement;

    public Credit(Client client, String account, Product product, CreditCard creditCard, Double interestRate, double balance, double lineCredit, double initialLineCredit, String currency, boolean status, Date createAt, Date cancelAt, Date lastMovement) {
        this.client = client;
        this.account = account;
        this.product = product;
        this.creditCard = creditCard;
        this.interestRate = interestRate;
        this.balance = balance;
        this.lineCredit = lineCredit;
        this.initialLineCredit = initialLineCredit;
        this.currency = currency;
        this.status = status;
        this.createAt = createAt;
        this.cancelAt = cancelAt;
        this.lastMovement = lastMovement;
    }
}
