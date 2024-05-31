package pe.com.prestacash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TipoArtefactoController {

    @GetMapping("/tipoartefacto/mostrar")
    public String MostrarTipoArtefacto() {
        return "tipoartefacto/mostrar_tipoartefacto";
    }

    @GetMapping("/tipoartefacto/registrar")
    public String MostrarRegistrarTipoArtefacto() {
        return "tipoartefacto/registrar_tipoartefacto";
    }

    @GetMapping("/tipoartefacto/actualizar")
    public String MostrarActualizarTipoArtefacto() {
        return "tipoartefacto/actualizar_tipoartefacto";
    }

    @GetMapping("/tipoartefacto/eliminar")
    public String MostrarEliminarTipoArtefacto() {
        return "tipoartefacto/eliminar_tipoartefacto";
    }
}