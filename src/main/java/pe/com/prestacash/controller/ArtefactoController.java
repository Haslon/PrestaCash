package pe.com.prestacash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.prestacash.model.ArtefactoEntity;
import pe.com.prestacash.service.ArtefactoService;
import pe.com.prestacash.service.TipoArtefactoService;

@Controller
public class ArtefactoController {

    @Autowired
    private ArtefactoService servicio;

    @Autowired
    private TipoArtefactoService serviciotipoartefacto;

    @GetMapping("/artefacto/mostrar")
    public String MostrarArtefacto(Model modelo) {
        modelo.addAttribute("artefactos",
                servicio.findAllCustom());
        return "artefacto/mostrar_artefacto";
    }

    @GetMapping("/artefacto/registrar")
    public String MostrarRegistrarArtefacto(Model modelo) {
        modelo.addAttribute("tipoartefactos",
                serviciotipoartefacto.findAllCustom());
        return "artefacto/registrar_artefacto";
    }

    @GetMapping("/artefacto/actualizar/{id}")
    public String MostrarActualizarArtefacto(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("tipoartefactos", serviciotipoartefacto.findAll());
        modelo.addAttribute("artefactos", servicio.findById(id).get());
        return "artefacto/actualizar_artefacto";
    }

    @GetMapping("/artefacto/eliminar/{id}")
    public String MostrarEliminarArtefacto(@PathVariable Long id) {
        ArtefactoEntity objartefacto = servicio.findById(id).get();
        servicio.delete(objartefacto);
        return "redirect:/artefacto/mostrar";
    }

    @ModelAttribute("artefacto")
    public ArtefactoEntity ModeloRol() {
        return new ArtefactoEntity();
    }

    @PostMapping("/artefacto/registrar")
    public String RegistrarTipoArtefacto(
            @ModelAttribute("artefacto") ArtefactoEntity a) {
        servicio.add(a);
        return "redirect:/artefacto/mostrar";
    }

    @PostMapping("/artefacto/actualizar/{id}")
    public String ActualizarArtefacto(@PathVariable Long id,
            @ModelAttribute("tipoartefacto") ArtefactoEntity a) {
        servicio.update(a);
        return "redirect:/artefacto/mostrar";
    }

}
