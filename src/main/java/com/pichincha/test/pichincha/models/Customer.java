package com.pichincha.test.pichincha.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Customer extends Person {
    
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts;

    /**
     * Ontiene el id del cliente
     * @return
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Cambia el valor del id del cliente
     * @param customerId
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Obtiene la contraseña del cliente
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Cambia el valor de la contraseña
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el estado del cliente
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * Cambia el estado del cliente
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
