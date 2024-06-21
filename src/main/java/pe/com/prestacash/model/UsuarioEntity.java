
package pe.com.prestacash.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.prestacash.model.base.BaseEntity;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "UsuarioEntity")
@Table(name = "usuario")
public class UsuarioEntity extends BaseEntity implements Serializable {

    private static final long serialVersion = 1L;
    @Id
    @Column(name = "codigo_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nombre_usuario")
    @NotEmpty
    @Size(min = 8, max = 15, message = "El nombre del usuario  tiene que estar entre {min} y {max}")
    private String nombre;
    @Column(name = "clave_usuario")
    @NotEmpty
    @Size(min = 8, max = 16, message = "La clave del usuario tiene que estar entre {min} y {max}")
    private String clave;
    @ManyToOne
    @JoinColumn(name = "codigo_rol", nullable = false)
    private RolEntity rol;
}
