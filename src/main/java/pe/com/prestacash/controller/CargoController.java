package pe.com.prestacash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.prestacash.model.CargoEntity;
import pe.com.prestacash.service.CargoService;


@Controller
public class CargoController {

    @Autowired
    private CargoService servicio;

    @GetMapping("/cargo/mostrar")
    public String MostrarCargo(Model modelo) {
        modelo.addAttribute("cargos",
                servicio.findAllCustom());
        return "cargo/mostrar_cargo";
    } 
    
    @GetMapping("/cargo/mostrartodo")
    public String MostrarCargoTodo(Model modelo) {
        modelo.addAttribute("cargos",
                servicio.findAll());
        return "cargo/habilitar_cargo";
    }
    
    @GetMapping("/cargo/registrar")
    public String MostrarRegistrarCargo() {
        return "cargo/registrar_cargo";
    }
    
    @GetMapping("/cargo/actualizar/{id}")
    public String MostrarActualizarCargo(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("cargos",
                servicio.findById(id).get());
        return "cargo/actualizar_cargo";
    }
    
    @GetMapping("/cargo/eliminar/{id}")
    public String MostrarEliminarCargo(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("cargos",
                servicio.findById(id).get());
        return "cargo/eliminar_cargo";
    }
    
    //Modelo
    
    @ModelAttribute("cargo")
    public CargoEntity ModeloCargo() {
        return new CargoEntity();
    }
    
    @PostMapping("/cargo/registrar")
    public String RegistrarCargo(
            @ModelAttribute("cargo") CargoEntity ta) {
        servicio.add(ta);
        return "redirect:/cargo/mostrar";
    }
    
    @PostMapping("/cargo/actualizar/{id}")
    public String MostrarActualizarCargo(@PathVariable Long id,
            @ModelAttribute("cargo") CargoEntity ta) {
        servicio.update(ta);
        return "redirect:/cargo/mostrar";
    }
    
    @PostMapping("/cargo/eliminar/{id}")
    public String MostrarEliminarDistrito(@PathVariable Long id,
            @ModelAttribute("cargo") CargoEntity ta) {
        servicio.delete(ta);
        return "redirect:/cargo/mostrar";
    }
    
    @GetMapping("/cargo/habilitar/{id}")
    public String HabilitarRol(@PathVariable Long id) {
        CargoEntity objcargo = servicio.findById(id).get();
        servicio.enable(objcargo);
        return "redirect:/cargo/mostrar";
    }
    
        @GetMapping("/cargo/deshabilitar/{id}")
    public String DeshabilitarRol(@PathVariable Long id) {
        CargoEntity objcargo = servicio.findById(id).get();
        servicio.delete(objcargo);
        return "redirect:/cargo/mostrar";
    }
}
