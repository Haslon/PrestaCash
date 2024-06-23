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
import pe.com.prestacash.model.CargoEntity;
import pe.com.prestacash.service.CargoService;

@RestController
@RequestMapping("/cargo")
public class CargoRestController {
    @Autowired
    private CargoService servicio;

    @GetMapping
    public List<CargoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<CargoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public CargoEntity findById(@PathVariable long id) {
        return servicio.findById(id).get();
    }

    @PostMapping
    public CargoEntity add(@RequestBody CargoEntity ta) {
        return servicio.add(ta);
    }

    @PutMapping("/{id}")
    public CargoEntity update(@PathVariable long id, @RequestBody CargoEntity ta) {
        return servicio.update(ta);
    }

    @DeleteMapping("/{id}")
    public CargoEntity delete(@PathVariable long id, @RequestBody CargoEntity ta) {
        return servicio.delete(ta);
    }

    @PutMapping("/enable/{id}")
    public CargoEntity enable(@PathVariable long id, @RequestBody CargoEntity ta) {
        return servicio.enable(ta);
    }
    
}
