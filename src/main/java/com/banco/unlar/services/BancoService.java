package com.banco.unlar.services;

import com.banco.unlar.models.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase es un "Servicio" de Spring. (@Service le dice a Spring que esta clase maneja la lógica).
 * Como el profe pidió CERO base de datos, acá adentro simulamos la base usando ArrayLists (memoria).
 */
@Service
public class BancoService {

    // Nuestra "base de datos" simulada
    private List<Sucursal> sucursales;

    // El constructor se ejecuta cuando Spring arranca la aplicación
    public BancoService() {
        this.sucursales = new ArrayList<>();
        inicializarDatosServicio(); // Llamamos al método para llenar datos falsos
    }

    /**
     * Método interno que arma toda la estructura (el "Mock").
     */
    private void inicializarDatosServicio() {
        // 1. Creamos una Sucursal
        Sucursal sucursalCentro = new Sucursal(1L, "Sucursal Centro", "Av. Rivadavia 123");

        // 2. Creamos algunos Clientes
        Cliente cliente1 = new Cliente("11222333", "Juan Perez", "juan.perez@email.com");
        Cliente cliente2 = new Cliente("44555666", "Maria Gomez", "maria.gomez@email.com");

        // 3. Creamos Cuentas (Notá que creamos CajaAhorro y CuentaCorriente, nunca 'Cuenta' a secas porque es abstracta)
        CajaAhorro cajaAhorroJuan = new CajaAhorro("0000003100012345678901", 150000.0);
        CuentaCorriente ccMaria = new CuentaCorriente("0000003100098765432109", 50000.0);

        // 4. COMPOSICIÓN en acción: Agarramos la lista de Movimientos de cada cuenta y le añadimos nuevos Movimientos.
        cajaAhorroJuan.getMovimientos().add(new Movimiento(LocalDateTime.now().minusDays(2), 50000.0, "Depósito inicial"));
        cajaAhorroJuan.getMovimientos().add(new Movimiento(LocalDateTime.now().minusDays(1), -5000.0, "Extracción cajero"));

        ccMaria.getMovimientos().add(new Movimiento(LocalDateTime.now().minusDays(5), 100000.0, "Transferencia recibida"));
        ccMaria.getMovimientos().add(new Movimiento(LocalDateTime.now(), -20000.0, "Pago de servicios"));

        // 5. Asignar cuentas a los clientes: Agregamos la cuenta a la lista del cliente.
        cliente1.getCuentas().add(cajaAhorroJuan);
        cliente2.getCuentas().add(ccMaria);

        // 6. AGREGACIÓN en acción: Agregamos los clientes a la lista de la sucursal.
        sucursalCentro.getClientes().add(cliente1);
        sucursalCentro.getClientes().add(cliente2);

        // 7. Guardamos la sucursal completa (que ya tiene los clientes y cuentas adentro) en nuestra lista principal.
        this.sucursales.add(sucursalCentro);
    }

    // --- MÉTODOS PÚBLICOS PARA LEER LOS DATOS DESDE LOS CONTROLADORES ---

    public List<Sucursal> obtenerTodasLasSucursales() {
        return this.sucursales;
    }

    public List<Cliente> obtenerTodosLosClientes() {
        // Como los clientes están adentro de la sucursal, recorremos las sucursales para extraerlos
        List<Cliente> todosLosClientes = new ArrayList<>();
        for (Sucursal s : sucursales) {
            todosLosClientes.addAll(s.getClientes());
        }
        return todosLosClientes;
    }

    public List<Cuenta> obtenerTodasLasCuentas() {
        // Idem, recorremos los clientes y extraemos sus cuentas
        List<Cuenta> todasLasCuentas = new ArrayList<>();
        for (Cliente c : obtenerTodosLosClientes()) {
            todasLasCuentas.addAll(c.getCuentas());
        }
        return todasLasCuentas;
    }
}
