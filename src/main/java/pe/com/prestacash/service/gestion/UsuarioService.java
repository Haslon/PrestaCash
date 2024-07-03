/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.prestacash.service.gestion;

import java.util.List;
import pe.com.prestacash.model.gestion.UsuarioEntity;
import pe.com.prestacash.service.base.BaseService;


public interface UsuarioService  extends BaseService<UsuarioEntity> {
    public List<UsuarioEntity> signin(UsuarioEntity u);
    
}
