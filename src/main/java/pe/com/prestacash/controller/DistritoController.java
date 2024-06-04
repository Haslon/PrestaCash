package pe.com.prestacash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.prestacash.model.DistritoEntity;
import pe.com.prestacash.model.TipoArtefactoEntity;
import pe.com.prestacash.service.DistritoService;

@Controller
public class DistritoController {

    @Autowired
    private DistritoService servicio;

    @GetMapping("/distrito/mostrar")
    public String MostrarArtefacto(Model modelo) {
        modelo.addAttribute("distritos",
                servicio.findAllCustom());
        return "distrito/mostrar_distrito";
    }
    
    @GetMapping("/distrito/mostrartodo")
    public String MostrarDistrito(Model modelo) {
        modelo.addAttribute("distritos",
                servicio.findAll());
        return "distrito/habilitar_distrito";
    }
    
    @GetMapping("/distrito/registrar")
    public String MostrarRegistrarDistrito() {
        return "distrito/registrar_distrito";
    }
    
    @GetMapping("/distrito/actualizar/{id}")
    public String MostrarActualizarDistrito(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("distritos",
                servicio.findById(id).get());
        return "distrito/actualizar_distrito";
    }
    
    @GetMapping("/distrito/eliminar/{id}")
    public String MostrarEliminarDistrito(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("distritos",
                servicio.findById(id).get());
        return "distrito/eliminar_distrito";
    }
    
    //modelo
    
    @ModelAttribute("distrito")
    public DistritoEntity ModeloDistrito() {
        return new DistritoEntity();
    }
    
    @PostMapping("/distrito/registrar")
    public String RegistrarDistrito(
            @ModelAttribute("distrito") DistritoEntity ta) {
        servicio.add(ta);
        return "redirect:/distrito/mostrar";
    }
    
    @PostMapping("/distrito/actualizar/{id}")
    public String MostrarActualizarDistrito(@PathVariable Long id,
            @ModelAttribute("distrito") DistritoEntity ta) {
        servicio.update(ta);
        return "redirect:/distrito/mostrar";
    }

    @PostMapping("/distrito/eliminar/{id}")
    public String MostrarEliminarDistrito(@PathVariable Long id,
            @ModelAttribute("distrito") DistritoEntity ta) {
        servicio.delete(ta);
        return "redirect:/distrito/mostrar";
    }
    
    @GetMapping("/distrito/habilitar/{id}")
    public String HabilitarRol(@PathVariable Long id) {
        DistritoEntity objdistrito = servicio.findById(id).get();
        servicio.enable(objdistrito);
        return "redirect:/distrito/mostrar";
    }
    
        @GetMapping("/distrito/deshabilitar/{id}")
    public String DeshabilitarRol(@PathVariable Long id) {
        DistritoEntity objdistrito = servicio.findById(id).get();
        servicio.delete(objdistrito);
        return "redirect:/distrito/mostrar";
    }

}
