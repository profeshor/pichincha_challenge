package com.pichincha.test.pichincha.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "initial_amount")
    private double initialAmount;
    
    @Column(name = "status")
    private int status;
    
    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName="id")
    private Customer customer;

    /**
     * Obtener el id
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtiene número de cuenta
     * @return
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Setea número de cuenta
     * @param accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Obtiene tipo de cuenta
     * @return
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Setea número de cuenta
     * @param accountType
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * Obtiene monto inicial de cuenta
     * @return
     */
    public double getInitialAmount() {
        return initialAmount;
    }

    /**
     * Obtiene el monto inicial
     * @param initialAmount
     */
    public void setInitialAmount(double initialAmount) {
        this.initialAmount = initialAmount;
    }

    /**
     * Obtiene el estado
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * Cambia el valor del estado
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Obtiene el propietario
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Cambia el propietario de la cuenta
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
