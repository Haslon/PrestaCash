package pe.com.prestacash.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.prestacash.model.ContratoEntity;
import pe.com.prestacash.service.ContratoService;

import java.util.List;

@RestController
@RequestMapping("/contrato")
public class ContratoRestController {

    @Autowired
    private ContratoService servicio;

    @GetMapping
    public List<ContratoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ContratoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public ContratoEntity findById(@PathVariable long id) {
        return servicio.findById(id).get();
    }

    @PostMapping
    public ContratoEntity add(@RequestBody ContratoEntity ta) {
        return servicio.add(ta);
    }

    @PutMapping("/{id}")
    public ContratoEntity update(@PathVariable long id, @RequestBody ContratoEntity ta) {
        return servicio.update(ta);
    }

    @DeleteMapping("/{id}")
    public ContratoEntity delete(@PathVariable long id, @RequestBody ContratoEntity ta) {
        return servicio.delete(ta);
    }

    @PutMapping("/enable/{id}")
    public ContratoEntity enable(@PathVariable long id, @RequestBody ContratoEntity ta) {
        return servicio.enable(ta);
    }


}
