/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.prestacash.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.prestacash.model.ArtefactoEntity;
import pe.com.prestacash.service.ArtefactoService;

@RestController
@RequestMapping("/artefacto")
public class ArtefactoRestController {
    @Autowired
    private ArtefactoService servicio;

    @GetMapping
    public List<ArtefactoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ArtefactoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public ArtefactoEntity findById(@PathVariable long id) {
        return servicio.findById(id).get();
    }

    @PostMapping
    public ArtefactoEntity add(@RequestBody ArtefactoEntity ta) {
        return servicio.add(ta);
    }

    @PutMapping("/{id}")
    public ArtefactoEntity update(@PathVariable long id, @RequestBody ArtefactoEntity ta) {
        return servicio.update(ta);
    }

    @DeleteMapping("/{id}")
    public ArtefactoEntity delete(@PathVariable long id, @RequestBody ArtefactoEntity ta) {
        return servicio.delete(ta);
    }

    @PutMapping("/enable/{id}")
    public ArtefactoEntity enable(@PathVariable long id, @RequestBody ArtefactoEntity ta) {
        return servicio.enable(ta);
    }
}
