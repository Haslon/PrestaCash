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
import pe.com.prestacash.model.DistritoEntity;
import pe.com.prestacash.service.DistritoService;

@RestController
@RequestMapping("/distrito")
public class DistritoRestController {
    @Autowired
    private DistritoService servicio;

    @GetMapping
    public List<DistritoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<DistritoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public DistritoEntity findById(@PathVariable long id) {
        return servicio.findById(id).get();
    }

    @PostMapping
    public DistritoEntity add(@RequestBody DistritoEntity ta) {
        return servicio.add(ta);
    }

    @PutMapping("/{id}")
    public DistritoEntity update(@PathVariable long id, @RequestBody DistritoEntity ta) {
        return servicio.update(ta);
    }

    @DeleteMapping("/{id}")
    public DistritoEntity delete(@PathVariable long id, @RequestBody DistritoEntity ta) {
        return servicio.delete(ta);
    }

    @PutMapping("/enable/{id}")
    public DistritoEntity enable(@PathVariable long id, @RequestBody DistritoEntity ta) {
        return servicio.enable(ta);
    }
    
}
