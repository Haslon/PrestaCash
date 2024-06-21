
package pe.com.prestacash.restcontroller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.prestacash.model.TipoArtefactoEntity;
import pe.com.prestacash.service.TipoArtefactoService;

@RestController
@RequestMapping("/tipoartefacto")
public class TipoArtefactoRestController {

    @Autowired
    private TipoArtefactoService servicio;

    @GetMapping
    public List<TipoArtefactoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<TipoArtefactoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public TipoArtefactoEntity findById(@PathVariable long id) {
        return servicio.findById(id).get();
    }

    @PostMapping
    public TipoArtefactoEntity add(@RequestBody TipoArtefactoEntity ta) {
        return servicio.add(ta);
    }

    @PutMapping("/{id}")
    public TipoArtefactoEntity update(@PathVariable long id, @RequestBody TipoArtefactoEntity ta) {
        return servicio.update(ta);
    }

    @DeleteMapping("/delete/{id}")
    public TipoArtefactoEntity delete(@PathVariable long id, @RequestBody TipoArtefactoEntity ta) {
        return servicio.delete(ta);
    }

    @PutMapping("/enable/{id}")
    public TipoArtefactoEntity enable(@PathVariable long id, @RequestBody TipoArtefactoEntity ta) {
        return servicio.enable(ta);
    }
}


