package com.pichincha.test.pichincha.controllers;

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

import com.pichincha.test.pichincha.models.AccountRepository;
import com.pichincha.test.pichincha.models.Customer;
import com.pichincha.test.pichincha.models.CustomerRepository;
import com.pichincha.test.pichincha.models.Account;

@RestController
@RequestMapping("/cuentas")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Listado de cuentas
     * @return
     */
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Obtiene una cuenta
     * @param id Id de la cuenta a obtener
     * @return
     */
    @GetMapping("/{id}")
    public Account getSingleAccount(@PathVariable long id) {
        return accountRepository.findById(id).get();
    }

    /**
     * Crear una nueva cuenta
     * @param account Cuerpo del HTTP Request
     * @return
     */
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        Long customerId = account.getCustomer().getId();
        Customer customer = customerRepository.findById(customerId).orElseThrow(
            () -> new ResourceNotFoundException("No existe el cliente con id: " + customerId)
        );
        account.setCustomer(customer);
        return accountRepository.save(account);
    }

    /**
     * Actualizar cuenta
     * @param id id de la cuenta a actualizar
     * @param accountDetails Cuerpo de la cuenta
     * @return
     */
    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable long id, @RequestBody Account accountDetails){
        Account account = accountRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Empleado con id: " + id + " no existe.")
        );
        account.setAccountNumber(accountDetails.getAccountNumber());
        account.setAccountType(accountDetails.getAccountType());
        account.setInitialAmount(accountDetails.getInitialAmount());
        account.setStatus(account.getStatus());
        Long customerId = account.getCustomer().getId();
        Customer customer = customerRepository.findById(customerId).orElseThrow(
            () -> new ResourceNotFoundException("No existe el cliente con id: " + customerId)
        );
        account.setCustomer(customer);
        return accountRepository.save(account);
    }

    /**
     * Elimina una cuenta
     * @param id id de la cuenta a eliminar
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable long id) {
        Account account = accountRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Empleado con id: " + id + " no existe.")
        );
        accountRepository.delete(account);
        return ResponseEntity.noContent().build();
    }
}
