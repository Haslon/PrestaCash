
package pe.com.prestacash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.prestacash.model.ClienteEntity;
import pe.com.prestacash.service.ClienteService;
import pe.com.prestacash.service.TipoDocumentoService;
import pe.com.prestacash.service.DistritoService;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/cliente/mostrar")
    public String MostrarClientes(Model modelo) {
        modelo.addAttribute("clientes", clienteService.findAllCustom());
        return "cliente/mostrar_cliente";
    }

    @GetMapping("/cliente/mostrartodo")
    public String MostrarClientesTodo(Model modelo) {
        modelo.addAttribute("clientes", clienteService.findAll());
        return "cliente/habilitar_cliente";
    }

    @GetMapping("/cliente/registrar")
    public String MostrarRegistrarCliente(Model modelo) {
        modelo.addAttribute("tiposdocumento", tipoDocumentoService.findAllCustom());
        modelo.addAttribute("distritos", distritoService.findAllCustom());
        return "cliente/registrar_cliente";
    }

    @PostMapping("/cliente/registrar")
    public String RegistrarCliente(@ModelAttribute("cliente") ClienteEntity clienteEntity) {
        clienteService.add(clienteEntity);
        return "redirect:/cliente/mostrar";
    }

    @GetMapping("/cliente/actualizar/{id}")
    public String MostrarActualizarCliente(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("tiposdocumento", tipoDocumentoService.findAll());
        modelo.addAttribute("distritos", distritoService.findAll());
        modelo.addAttribute("cliente", clienteService.findById(id).get());
        return "cliente/actualizar_cliente";
    }

    @PostMapping("/cliente/actualizar/{id}")
    public String ActualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") ClienteEntity ce) {
        clienteService.update(ce);
        return "redirect:/cliente/mostrar";
    }

    @GetMapping("/cliente/eliminar/{id}")
    public String MostrarEliminarCliente(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("tiposdocumento", tipoDocumentoService.findAll());
        modelo.addAttribute("distritos", distritoService.findAll());
        modelo.addAttribute("cliente", clienteService.findById(id).get());
        return "cliente/eliminar_cliente";
    }

    @PostMapping("/cliente/eliminar/{id}")
    public String EliminarCliente(@PathVariable Long id, @ModelAttribute("cliente") ClienteEntity clienteEntity) {
        clienteService.delete(clienteEntity);
        return "redirect:/cliente/mostrar";
    }

    @ModelAttribute("cliente")
    public ClienteEntity ModeloCliente() {
        return new ClienteEntity();
    }

    @GetMapping("/cliente/habilitar/{id}")
    public String HabilitarCliente(@PathVariable Long id) {
        ClienteEntity clienteEntity = clienteService.findById(id).get();
        clienteService.enable(clienteEntity);
        return "redirect:/cliente/mostrar";
    }

    @GetMapping("/cliente/deshabilitar/{id}")
    public String DeshabilitarCliente(@PathVariable Long id) {
        ClienteEntity clienteEntity = clienteService.findById(id).get();
        clienteService.delete(clienteEntity);
        return "redirect:/cliente/mostrar";
    }
}
