package pe.com.prestacash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.prestacash.service.CargoService;
import pe.com.prestacash.service.DistritoService;
import pe.com.prestacash.service.EmpleadoService;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService servicio;


    @GetMapping("/empleado/mostrar")
    public String MostrarEmpleado(Model modelo) {
        modelo.addAttribute("empleados",
                servicio.findAllCustom());
        return "empleado/mostrar_empleados";
    }

}
