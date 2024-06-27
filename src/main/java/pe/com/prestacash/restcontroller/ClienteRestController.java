/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.prestacash.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.prestacash.model.ClienteEntity;
import pe.com.prestacash.service.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
        @Autowired
    private ClienteService servicio;

    @GetMapping
    public List<ClienteEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ClienteEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public ClienteEntity findById(@PathVariable long id) {
        return servicio.findById(id).get();
    }

    @PostMapping
    public ClienteEntity add(@RequestBody ClienteEntity ta) {
        return servicio.add(ta);
    }

    @PutMapping("/{id}")
    public ClienteEntity update(@PathVariable long id, @RequestBody ClienteEntity ta) {
        return servicio.update(ta);
    }

    @DeleteMapping("/{id}")
    public ClienteEntity delete(@PathVariable long id, @RequestBody ClienteEntity ta) {
        return servicio.delete(ta);
    }

    @PutMapping("/enable/{id}")
    public ClienteEntity enable(@PathVariable long id, @RequestBody ClienteEntity ta) {
        return servicio.enable(ta);
    }
}
