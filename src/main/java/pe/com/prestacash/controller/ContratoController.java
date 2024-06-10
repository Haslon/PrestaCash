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

import pe.com.prestacash.model.ClienteEntity;
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

        @ModelAttribute("contrato")
        public ContratoEntity ModeloCliente() {
                return new ContratoEntity();
        }

        @GetMapping("/contrato/mostrar")
        public String MostrarContrato(Model modelo) {
                modelo.addAttribute("contratos",
                                servicio.findAllCustom());
                return "contrato/mostrar_contrato";
        }

        @GetMapping("/contrato/registrar")
        public String MostrarRegistarContrato(Model modelo) {
                modelo.addAttribute("clientes",
                                clienteService.findAllCustom());
                modelo.addAttribute("empleados",
                                empleadoService.findAllCustom());
                return "contrato/registrar_contrato";
        }

        @PostMapping("/contrato/registrar")
        public String RegistrarContrato(@ModelAttribute("contrato") ContratoEntity contratoEntity) {
                servicio.add(contratoEntity);
                return "redirect:/contrato/mostrar";
        }

        @GetMapping("/contrato/habilitar")
        public String HabilitarContrato(Model modelo) {
                modelo.addAttribute("contratos",
                                servicio.findAll());
                return "contrato/habilitar_contrato";
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
                ContratoEntity contrato = servicio.findById(id).get();
                modelo.addAttribute("contrato",
                                contrato);
                modelo.addAttribute("empleado",
                                contrato.getEmpleado());
                modelo.addAttribute("cliente",
                                contrato.getCliente());
                return "contrato/eliminar_contrato";
        }

        @PostMapping("/contrato/actualizar")
        public String ActualizarContrato(
                        @ModelAttribute("contrato") ContratoEntity ct) {
                servicio.update(ct);
                return "redirect:/contrato/mostrar";
        }

        @PostMapping("/contrato/eliminar/{id}")
        public String EliminarContrato(@PathVariable Long id,
                        @ModelAttribute("contrato") ContratoEntity ct) {
                servicio.delete(ct);
                return "redirect:/contrato/mostrar";
        }

        @GetMapping("/contrato/habilitar/{id}")
        public String HabilitarCliente(@PathVariable Long id) {
                ContratoEntity ct = servicio.findById(id).get();
                servicio.enable(ct);
                return "redirect:/contrato/mostrar";
        }

        @GetMapping("/contrato/deshabilitar/{id}")
        public String DeshabilitarCliente(@PathVariable Long id) {
                ContratoEntity ct = servicio.findById(id).get();
                servicio.delete(ct);
                return "redirect:/contrato/mostrar";
        }

}
