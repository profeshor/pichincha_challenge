package com.pichincha.test.pichincha.controllers;
 
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.test.pichincha.models.Movement;
import com.pichincha.test.pichincha.models.MovementRepository;


@RestController
@RequestMapping("/reportes")
public class ReportController {
    @Autowired
    private MovementRepository movementRepository;

    /**
     * Obtiene reporte por rango de fechas
     * @param initialDate Fecha inicial
     * @param endDate Fecha de corte
     * @return
     */
    @GetMapping
    public List<Movement> getMovementsByDateRange(@RequestParam("initialDate") @DateTimeFormat(iso =  DateTimeFormat.ISO.DATE_TIME) LocalDateTime initialDate,
                        @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
                            return movementRepository.findAllByLocalDateTimeBetween(initialDate, endDate); 
                        }
}
