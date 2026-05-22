package com.banco.unlar.controllers;

import com.banco.unlar.models.Cuenta;
import com.banco.unlar.services.BancoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador que maneja las peticiones relacionadas a las Cuentas bancarias.
 * Ruta de acceso: localhost:8080/api/cuentas
 */
@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private final BancoService bancoService;

    public CuentaController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    // Responde peticiones HTTP GET y devuelve las cuentas creadas en el BancoService
    @GetMapping
    public List<Cuenta> getCuentas() {
        return bancoService.obtenerTodasLasCuentas();
    }
}
