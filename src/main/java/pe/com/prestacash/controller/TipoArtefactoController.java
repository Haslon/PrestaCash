package pe.com.prestacash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.prestacash.model.TipoArtefactoEntity;
import pe.com.prestacash.service.TipoArtefactoService;

@Controller
public class TipoArtefactoController {

    @Autowired
    private TipoArtefactoService servicio;

    //@GetMapping --> para poder manejar las rutas --> obtener una ruta y mostrar
    //la vista correspondiente(.html)
    //Para cargar datos en la vista primero agregamos un modelo de tipo Model
    //en ese modelo enviaremos los datos hacia la vista, haciendo uso de una
    //variable de envio, en este caso sera "tipoartefacto" y dentro de esa variable
    //podemos enviar la informacion en este caso enviamos la funcion findAllCustom
    //que te hace una consulta a la base de datos y te trae toda la informacion
    @GetMapping("/tipoartefacto/mostrar")
    public String MostrarTipoArtefacto(Model modelo) {
        modelo.addAttribute("tipoartefactos",
                servicio.findAllCustom());
        return "tipoartefacto/mostrar_tipoartefacto";
    }

    @GetMapping("/tipoartefacto/mostrartodo")
    public String MostrarTipoArtefactoTodo(Model modelo) {
        modelo.addAttribute("tipoartefactos",
                servicio.findAll());
        return "tipoartefacto/habilitar_tipoartefacto";
    }

    @GetMapping("/tipoartefacto/registrar")
    public String MostrarRegistrarTipoArtefacto() {
        return "tipoartefacto/registrar_tipoartefacto";
    }

    @GetMapping("/tipoartefacto/actualizar/{id}")
    public String MostrarActualizarTipoArtefacto(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("tipoartefactos",
                servicio.findById(id).get());
        return "tipoartefacto/actualizar_tipoartefacto";
    }

    @GetMapping("/tipoartefacto/eliminar/{id}")
    public String MostrarEliminarTipoArtefacto(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("tipoartefactos",
                servicio.findById(id).get());
        return "tipoartefacto/eliminar_tipoartefacto";
    }

    //creamos el modelo para poder trasportar la informacion
    @ModelAttribute("tipoartefacto")
    public TipoArtefactoEntity ModeloRol() {
        return new TipoArtefactoEntity();
    }

    @PostMapping("/tipoartefacto/registrar")
    public String RegistrarTipoArtefacto(
            @ModelAttribute("tipoartefacto") TipoArtefactoEntity ta) {
        servicio.add(ta);
        return "redirect:/tipoartefacto/mostrar";
    }

    @PostMapping("/tipoartefacto/actualizar/{id}")
    public String ActualizarTipoArtefacto(@PathVariable Long id,
            @ModelAttribute("tipoartefacto") TipoArtefactoEntity ta) {
        servicio.update(ta);
        return "redirect:/tipoartefacto/mostrar";
    }

    @PostMapping("/tipoartefacto/eliminar/{id}")
    public String EliminarTipoArtefacto(@PathVariable Long id,
            @ModelAttribute("tipoartefacto") TipoArtefactoEntity ta) {
        servicio.delete(ta);
        return "redirect:/tipoartefacto/mostrar";
    }

    @GetMapping("/tipoartefacto/habilitar/{id}")
    public String HabilitarRol(@PathVariable Long id) {
        TipoArtefactoEntity objtipoartefacto = servicio.findById(id).get();
        servicio.enable(objtipoartefacto);
        return "redirect:/tipoartefacto/mostrar";
    }
    
        @GetMapping("/tipoartefacto/deshabilitar/{id}")
    public String DeshabilitarRol(@PathVariable Long id) {
        TipoArtefactoEntity objtipoartefacto = servicio.findById(id).get();
        servicio.delete(objtipoartefacto);
        return "redirect:/tipoartefacto/mostrar";
    }
}
