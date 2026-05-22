package com.banco.unlar.controllers;

import com.banco.unlar.models.Sucursal;
import com.banco.unlar.services.BancoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @RestController le dice a Spring: "Esta clase va a recibir peticiones de internet y devolver JSON".
 * @RequestMapping("/api/sucursales") dice que la ruta base (URL) para entrar acá es localhost:8080/api/sucursales.
 */
@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    // Necesitamos el servicio para acceder a los datos guardados en memoria
    private final BancoService bancoService;

    // INYECCIÓN DE DEPENDENCIAS: Spring se encarga automáticamente de pasarnos el BancoService ya creado.
    public SucursalController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    /**
     * @GetMapping significa que si alguien entra a la ruta por el método GET (solo leer), se ejecuta esto.
     * Devuelve la lista completa, y Spring automáticamente la transforma en formato JSON.
     */
    @GetMapping
    public List<Sucursal> getSucursales() {
        return bancoService.obtenerTodasLasSucursales();
    }
}
