/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.prestacash.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.prestacash.model.UsuarioEntity;
import pe.com.prestacash.service.UsuarioService;

@Controller
public class UsuarioController {
    
    
    @Autowired
    private UsuarioService servicio;
    
    @ModelAttribute("usuario")
    public UsuarioEntity ModeloUsuario(){
        return new UsuarioEntity();
    }
    
    @PostMapping("/usuario/ingresar")
    public String ValidarUsuario(
    @ModelAttribute("usuario") UsuarioEntity u){
    List<UsuarioEntity> lista= servicio.signin(u);
     if (lista.size() == 1) {
            return "menuprincipal/menuprincipal";
        } else {
            return "index";
        }
   }
}
