
package pe.com.prestacash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.prestacash.model.AlmacenEntity;
import pe.com.prestacash.service.AlmacenService;
import pe.com.prestacash.service.ArtefactoService;

@Controller
public class AlmacenController {
    
    @Autowired
    private AlmacenService servicio;
    
    @Autowired
    private ArtefactoService servicioartefacto;
    
    @GetMapping("/almacen/mostrar")
    public String MostrarAlmacen(Model modelo) {
        modelo.addAttribute("almacen",
                servicio.findAllCustom());
        return "almacen/mostrar_almacen";
    }
    
    @GetMapping("/almacen/mostrartodo")
    public String MostrarAlmacenTodo(Model modelo) {
        modelo.addAttribute("almacen",
                servicio.findAll());
        return "almacen/habilitar_almacen";
    }

    
    @GetMapping("/almacen/registrar")
    public String MostrarRegistrarAlmacen(Model modelo) {
        modelo.addAttribute("artefactos",
                servicioartefacto.findAllCustom());
        return "almacen/registrar_almacen";
    }
    
    @PostMapping("/almacen/registrar")
    public String RegistrarAlmacen(
        @ModelAttribute("almacen") AlmacenEntity almacenEntity) {
        servicio.add(almacenEntity);
        return "redirect:/almacen/mostrar/custom";
    }

    
    @GetMapping("/almacen/actualizar/{id}")
    public String MostrarActualizarAlmacen(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("artefactos", servicioartefacto.findAll());
        modelo.addAttribute("almacen", servicio.findById(id).get());
        return "almacen/actualizar_almacen";
    }
    
    @PostMapping("/almacen/actualizar/{id}")
    public String ActualizarAlmacen(@PathVariable Long id,
            @ModelAttribute("almacen") AlmacenEntity a) {
        servicio.update(a);
        return "redirect:/almacen/mostrar/custom";
    }
    
    @GetMapping("/almacen/eliminar/{id}")
    public String MostrarEliminarAlmacen(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("artefactos", servicioartefacto.findAll());
        modelo.addAttribute("almacen", servicio.findById(id).get());
        return "almacen/eliminar_almacen";
    }
    
    @PostMapping("/almacen/eliminar/{id}")
    public String EliminarAlmacen(@PathVariable Long id,
            @ModelAttribute("almacen") AlmacenEntity a) {
        servicio.delete(a);
        return "redirect:/almacen/mostrar/custom";
    }
    
    @ModelAttribute("almacen")
    public AlmacenEntity ModeloRol() {
        return new AlmacenEntity();
    }
   

    @GetMapping("/almacen/habilitar/{id}")
    public String HabilitarRol(@PathVariable Long id) {
        AlmacenEntity objalmacen = servicio.findById(id).get();
        servicio.enable(objalmacen);
        return "redirect:/almacen/mostrar/custom";
    }
    
        @GetMapping("/almacen/deshabilitar/{id}")
    public String DeshabilitarRol(@PathVariable Long id) {
        AlmacenEntity objalmacen = servicio.findById(id).get();
        servicio.delete(objalmacen);
        return "redirect:/almacen/mostrar/custom";
    }
    
}
