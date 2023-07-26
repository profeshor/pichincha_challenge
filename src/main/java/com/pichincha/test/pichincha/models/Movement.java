package com.pichincha.test.pichincha.models;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="movements")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Fecha y hora de movimiento
    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;
    
    // Tipo de movimiento
    @Column(name = "movement_type")
    private String movementType;

    // Valor del monto
    @Column(name = "movement_amount")
    private double movementAmount;

    // Saldo
    @Column(name = "account_amount")
    private double accountAmount;

    // Cuenta
    @ManyToOne
    @JoinColumn(name="account_id", referencedColumnName="id")
    private Account account;

    /**
     * Obtener id del movimiento
     * @return
     */
    public Long getId() {
        return this.id;
    }
    
    /**
     * Obtiene la fecha del movimiento
     * @return
     */
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    /**
     * Cambia el valor de la fecha del movimiento
     * @param localDateTime
     */
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    /**
     * Obtiene el tipo de movimiento
     * @return
     */
    public String getMovementType() {
        return movementType;
    }

    /**
     * Cambia el tipo de movimiento
     * @param movementType
     */
    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    /**
     * Obtiene el monto del movimiento
     * @return
     */
    public double getMovementAmount() {
        return movementAmount;
    }

    /**
     * Cambia el monto del movimiento
     * @param movementAmount
     */
    public void setMovementAmount(double movementAmount) {
        this.movementAmount = movementAmount;
    }

    /**
     * Obtiene el monto actual de la cuenta
     * @return
     */
    public double getAccountAmount() {
        return accountAmount;
    }

    /**
     * Cambia el monto actual de la cuenta
     * @param accountAmount
     */
    public void setAccountAmount(double accountAmount) {
        this.accountAmount = accountAmount;
    }

    /**
     * Obtiene la cuenta a la que se aplicó el movimiento
     * @return
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Cambia la cuenta a la que se aplicó el movimiento
     * @return
     * @param account
     */
    public void setAccount(Account account) {
        this.account = account;
    }
}
