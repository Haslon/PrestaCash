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
import pe.com.prestacash.model.TipoDocumentoEntity;
import pe.com.prestacash.service.TipoDocumentoService;

@Controller
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService servicio;

    @GetMapping("/tipodocumento/mostrar")
    public String MostrarTipoDocumento(Model modelo) {
        modelo.addAttribute("tipodocumentos",
                servicio.findAllCustom());
        return "tipodocumento/mostrar_tipodocumento";
    }    
    
    @GetMapping("/tipodocumento/registrar")
    public String MostrarRegistrarTipoDocumento() {
        return "tipodocumento/registrar_tipodocumento";
    }
    
    @GetMapping("/tipodocumento/actualizar/{id}")
    public String MostrarActualizarTipoDocumento(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("tipodocumentos",
                servicio.findById(id).get());
        return "tipodocumento/actualizar_tipodocumento";
    }
    
    @GetMapping("/tipodocumento/eliminar/{id}")
    public String MostrarEliminarTipoDocumento(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("tipodocumentos",
                servicio.findById(id).get());
        return "tipodocumento/eliminar_tipodocumento";
    }
    
    //Modelo
    
    @ModelAttribute("tipodocumento")
    public TipoDocumentoEntity ModeloTipoDocumento() {
        return new TipoDocumentoEntity();
    }
    
    @PostMapping("/tipodocumento/registrar")
    public String RegistrarCargo(
            @ModelAttribute("tipodocumento") TipoDocumentoEntity ta) {
        servicio.add(ta);
        return "redirect:/tipodocumento/mostrar";
    }
    
    @PostMapping("/tipodocumento/actualizar/{id}")
    public String MostrarActualizarCargo(@PathVariable Long id,
            @ModelAttribute("tipodocumento") TipoDocumentoEntity ta) {
        servicio.update(ta);
        return "redirect:/tipodocumento/mostrar";
    }
    
    @PostMapping("/tipodocumento/eliminar/{id}")
    public String MostrarEliminarDistrito(@PathVariable Long id,
            @ModelAttribute("tipodocumento") TipoDocumentoEntity ta) {
        servicio.delete(ta);
        return "redirect:/tipodocumento/mostrar";
    }
}
