package pe.com.prestacash.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.prestacash.model.EmpleadoEntity;
import pe.com.prestacash.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoRestController {
        @Autowired
    private EmpleadoService servicio;

    @GetMapping
    public List<EmpleadoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<EmpleadoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public EmpleadoEntity findById(@PathVariable long id) {
        return servicio.findById(id).get();
    }

    @PostMapping
    public EmpleadoEntity add(@RequestBody EmpleadoEntity ta) {
        return servicio.add(ta);
    }

    @PutMapping("/{id}")
    public EmpleadoEntity update(@PathVariable long id, @RequestBody EmpleadoEntity ta) {
        return servicio.update(ta);
    }

    @DeleteMapping("/{id}")
    public EmpleadoEntity delete(@PathVariable long id, @RequestBody EmpleadoEntity ta) {
        return servicio.delete(ta);
    }

    @PutMapping("/enable/{id}")
    public EmpleadoEntity enable(@PathVariable long id, @RequestBody EmpleadoEntity ta) {
        return servicio.enable(ta);
    }
}
