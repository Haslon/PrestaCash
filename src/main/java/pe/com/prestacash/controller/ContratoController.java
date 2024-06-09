/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.prestacash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.prestacash.model.CargoEntity;
import pe.com.prestacash.model.ContratoEntity;
import pe.com.prestacash.service.ClienteService;
import pe.com.prestacash.service.ContratoService;
import pe.com.prestacash.service.EmpleadoService;


@Controller
public class ContratoController {
    
    @Autowired
    private ClienteService clienteService;
        
    @Autowired
    private EmpleadoService empleadoService;
        
        
    @Autowired
    private ContratoService servicio;

    @GetMapping("/contrato/mostrar")
    public String MostrarContrato(Model modelo) {
        modelo.addAttribute("contratos",
                servicio.findAllCustom());
        return "contrato/mostrar_contrato";
    } 
    
    
    @GetMapping("/contrato/actualizar/{id}")
    public String MostrarActualizarContrato(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("clientes",
                clienteService.findAllCustom());
        modelo.addAttribute("empleados",
                empleadoService.findAllCustom());
        modelo.addAttribute("contrato",
                servicio.findById(id).get());
        return "contrato/actualizar_contrato";
    }
    
    @GetMapping("/contrato/eliminar/{id}")
    public String MostrarEliminarContrato(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("contrato",
                servicio.findById(id).get());
        return "contrato/eliminar_contrato";
    }
    
    
    @PostMapping("/contrato/actualizar/{id}")
    public String ActualizarContrato(@PathVariable Long id,
            @ModelAttribute("contrato") ContratoEntity ct) {
        servicio.update(ct);
        
        return "redirect:/contrato/mostrar";
    }
    
}
