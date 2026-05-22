package com.banco.unlar.controllers;

import com.banco.unlar.models.Cliente;
import com.banco.unlar.services.BancoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador exclusivo para manejar los Clientes. 
 * Separarlo ayuda a tener el código ordenado (Principio de Responsabilidad Única).
 * Ruta de acceso: localhost:8080/api/clientes
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final BancoService bancoService;

    public ClienteController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    // Endpoint GET que retorna la lista de clientes en formato JSON
    @GetMapping
    public List<Cliente> getClientes() {
        return bancoService.obtenerTodosLosClientes();
    }
}
