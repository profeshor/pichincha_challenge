package com.pichincha.test.pichincha.controllers;

import com.pichincha.test.pichincha.models.CustomerRepository;
import com.pichincha.test.pichincha.models.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;
    /**
     * Obtiene listado de clientes
     * @return
     */
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    /**
     * Obtiene un solo cliente
     * @param id id del cliente
     * @return
     */
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id).get();
    }

    /**
     * Crea un nuevo cliente
     * @param customer Cuerpo obtenido de HTTP request con datos del cliente
     * @return
     */
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Actualiza un cliente
     * @param id id del cliente a actualizar
     * @param customerDetails Detalles del cliente que se van a actualizar
     * @return
     */
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Customer customer = customerRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Empleado con id: " + id + " no existe.")
        );
        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setAddress(customerDetails.getAddress());
        customer.setAge(customerDetails.getAge());
        customer.setIdNumber(customerDetails.getIdNumber());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        customer.setGender(customerDetails.getGender());
        customer.setCustomerId(customerDetails.getCustomerId());
        customer.setPassword(customerDetails.getPassword());
        customer.setStatus(customerDetails.getStatus());

        return customerRepository.save(customer);
    }

    /**
     * Elimina un cliente
     * @param id id del cliente a eliminar
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
        customerRepository.delete(customer);
        return ResponseEntity.noContent().build();
    }
}
