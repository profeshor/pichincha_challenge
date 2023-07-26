package com.pichincha.test.pichincha.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.test.pichincha.exceptions.AmountOutOfRange;
import com.pichincha.test.pichincha.models.Account;
import com.pichincha.test.pichincha.models.AccountRepository;
import com.pichincha.test.pichincha.models.Movement;
import com.pichincha.test.pichincha.models.MovementRepository;

@RestController
@RequestMapping("/movimientos")
public class MovementsController {
    @Autowired 
    private MovementRepository movementRepository;
    @Autowired
    private AccountRepository accountRepository;

    /**
     * Obtinene listado movimientos
     * @return
     */
    @GetMapping
    public List<Movement> getAllMovements(){
        return movementRepository.findAll();
    }

    /**
     * Obtiene un solo movimiento
     * @param id id del movimiento
     * @return
     */
    @GetMapping("/{id}")
    public Movement getSingleMovement(@PathVariable long id){
        return movementRepository.findById(id).get();
    }

    /**
     * Crea un movimiento tomando en cuenta el monto del mismo y el saldo disponible
     * @param movement cuerpo del Http Request
     * @return
     * @throws AmountOutOfRange Manejador de excepción de saldo no disponible
     */
    @PostMapping
    public Movement createMovement(@RequestBody Movement movement) throws AmountOutOfRange{
        long accountId = movement.getAccount().getId();
        Account account = accountRepository.findById(accountId).orElseThrow(
            () -> new ResourceNotFoundException("La cuenta con id: " + accountId + " no existe.")
            );
            movement.setAccount(account);
        Double lastMovementAccountAmount = movementRepository.findTopByOrderByIdDesc().getAccountAmount();
        Double movementAmount = movement.getMovementAmount();
        if (movementAmount * -1 > lastMovementAccountAmount) {
            throw new AmountOutOfRange("Saldo no disponible", null);
        }
        movement.setAccountAmount(lastMovementAccountAmount += movementAmount);
        return movementRepository.save(movement);
    }

    /**
     * Actualizar detalles de movimiento
     * @param id id de movimiento
     * @param movementBody cuerpo del Http Request
     * @return
     */
    @PutMapping("/{id}")
    public Movement updateMovement(@PathVariable long id, @RequestBody Movement movementBody) {
        Movement movement = movementRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Empleado con id: " + id + " no existe.")
        );
        movement.setAccountAmount(movementBody.getAccountAmount());
        movement.setMovementAmount(movementBody.getMovementAmount());
        movement.setMovementType(movementBody.getMovementType());
        long accountId = movement.getAccount().getId();
        Account account = accountRepository.findById(accountId).orElseThrow(
            () -> new ResourceNotFoundException("La cuenta con id: " + accountId + " no existe.")
        );
        movement.setAccount(account);
        return movementRepository.save(movement);
    }

    /**
     * Elimina un movimiento
     * @param id id del movimiento a eliminar
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable long id) {
        Movement movement = movementRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Empleado con id: " + id + " no existe.")
        );
        movementRepository.delete(movement);
        return ResponseEntity.noContent().build();
    }

    /**
     * Manejador de Excepción de saldo no disponible
     * @param e
     * @return
     */
    @ExceptionHandler(AmountOutOfRange.class)
    public ResponseEntity<String> handleAmountOutOfRange(AmountOutOfRange e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}