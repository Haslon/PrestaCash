/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.prestacash.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.*;
import pe.com.prestacash.model.base.BaseEntity;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "RolEntity")
@Table(name = "rol")
public class RolEntity extends BaseEntity implements Serializable{
   
    private static final long serialVersion = 1L;
    @Id
    @Column(name = "codigo_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nombre_rol")
    @NotEmpty
    @Size(min = 10, max = 60, message = "El nombre del tipo de artefacto  tiene que estar entre {min} y {max}")
    private String nombre;
}
