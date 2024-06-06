package pe.com.prestacash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.prestacash.model.CargoEntity;
import pe.com.prestacash.model.DistritoEntity;
import pe.com.prestacash.model.EmpleadoEntity;
import pe.com.prestacash.model.TipoDocumentoEntity;
import pe.com.prestacash.service.CargoService;
import pe.com.prestacash.service.DistritoService;
import pe.com.prestacash.service.EmpleadoService;
import pe.com.prestacash.service.TipoDocumentoService;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    private CargoService cargoService;

    @GetMapping("/empleado/mostrar")
    public String mostrarEmpleado(Model model) {
        model.addAttribute("empleados", empleadoService.findAllCustom());
        return "empleado/mostrar_empleado";
    }
    
    @GetMapping("/empleado/mostrartodo")
    public String MostrarEmpleadoTodo(Model modelo) {
        modelo.addAttribute("empleados",
                empleadoService.findAll());
        return "empleado/habilitar_empleado";
    }
    

    @GetMapping("/empleado/registrar")
    public String mostrarRegistrarEmpleado(Model model) {
        model.addAttribute("distritos", distritoService.findAllCustom());
        model.addAttribute("tipodocumentos", tipoDocumentoService.findAllCustom());
        model.addAttribute("cargos", cargoService.findAllCustom());
        return "empleado/registrar_empleado";
    }

    @GetMapping("/empleado/actualizar/{id}")
    public String MostrarActualizarEmpleado(@PathVariable Long id, Model model) {
        model.addAttribute("distritos", distritoService.findAllCustom());
        model.addAttribute("tipodocumentos", tipoDocumentoService.findAllCustom());
        model.addAttribute("cargos", cargoService.findAllCustom());
        model.addAttribute("empleados", empleadoService.findById(id).get());
        return "empleado/actualizar_empleado";
    }

    @GetMapping("/empleado/eliminar/{id}")
    public String MostrarEliminarEmpleado(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("distritos", distritoService.findAllCustom());
        modelo.addAttribute("tipodocumentos", tipoDocumentoService.findAllCustom());
        modelo.addAttribute("cargos", cargoService.findAllCustom());
        modelo.addAttribute("empleados",
                empleadoService.findById(id).get());
        return "empleado/eliminar_empleado";
    }

    // modelo
    @ModelAttribute("empleado")
    public EmpleadoEntity ModeloEmpleado() {
        return new EmpleadoEntity();
    }

    @PostMapping("/empleado/registrar")
    public String registrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity a) {
        empleadoService.add(a);
        return "redirect:/empleado/mostrar";
    }

    @PostMapping("/empleado/actualizar/{id}")
    public String MostrarActualizarEmpleado(@PathVariable Long id,
            @ModelAttribute("empleado") EmpleadoEntity a) {
        empleadoService.update(a);
        return "redirect:/empleado/mostrar";
    }

    @PostMapping("/empleado/eliminar/{id}")
    public String EliminarEmpleado(@PathVariable Long id,
            @ModelAttribute("empleado") EmpleadoEntity a) {
        empleadoService.delete(a);
        return "redirect:/empleado/mostrar";
    }

    @GetMapping("/empleado/habilitar/{id}")
    public String HabilitarRol(@PathVariable Long id) {
        EmpleadoEntity objempleado = empleadoService.findById(id).get();
        empleadoService.enable(objempleado);
        return "redirect:/empleado/mostrar";
    }

    @GetMapping("/empleado/deshabilitar/{id}")
    public String DeshabilitarRol(@PathVariable Long id) {
        EmpleadoEntity objempleado = empleadoService.findById(id).get();
        empleadoService.delete(objempleado);
        return "redirect:/empleado/mostrar";
    }
}
