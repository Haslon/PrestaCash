
package pe.com.prestacash.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import pe.com.prestacash.model.AlmacenEntity;
import pe.com.prestacash.service.AlmacenService;

@RestController
@RequestMapping("/almacen")
public class AlmacenRestController {
       @Autowired
    private AlmacenService servicio;

    @GetMapping
    public List<AlmacenEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<AlmacenEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public AlmacenEntity findById(@PathVariable long id) {
        return servicio.findById(id).get();
    }

    @PostMapping
    public AlmacenEntity add(@RequestBody AlmacenEntity ta) {
        return servicio.add(ta);
    }

    @PutMapping("/{id}")
    public AlmacenEntity update(@PathVariable long id, @RequestBody AlmacenEntity ta) {
        return servicio.update(ta);
    }

    @DeleteMapping("/{id}")
    public AlmacenEntity delete(@PathVariable long id, @RequestBody AlmacenEntity ta) {
        return servicio.delete(ta);
    }

    @PutMapping("/enable/{id}")
    public AlmacenEntity enable(@PathVariable long id, @RequestBody AlmacenEntity ta) {
        return servicio.enable(ta);
    }
}
