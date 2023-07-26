package com.pichincha.test.pichincha.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;

@Entity
@Table(name="people")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
   
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private int age;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * Obtiene el id
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtiene el nombre
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Obtiene el apellido
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Obtiene el género
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     * Cambia el género
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Obtiene la edad
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Cambia la edad
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Obtiene el número de identificación
     * @return
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * Cambia el número de identificación
     * @param idNumber
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Obtiene la dirección de domicilio
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Cambia la dirección de domicilio
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Obtiene el teléfono
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Cambia el teléfono
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Obtiene el apellido
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Cambia el apellido
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
