package pe.com.prestacash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtefactoController {

    @GetMapping("/artefacto/mostrar")
    public String MostrarArtefacto() {
        return "artefacto/mostrar_artefacto";
    }
    
    @GetMapping("/artefacto/registrar")
    public String MostrarRegistrarArtefacto() {
        return "artefacto/registrar_artefacto";
    }

    @GetMapping("/artefacto/actualizar")
    public String MostrarActualizarArtefacto() {
        return "artefacto/actualizar_artefacto";
    }

    @GetMapping("/artefacto/eliminar")
    public String MostrarEliminarArtefacto() {
        return "artefacto/eliminar_artefacto";
    }
}