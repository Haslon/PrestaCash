package pe.com.prestacash.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.com.prestacash.model.base.BaseEntity;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "ClienteEntity")
@Table(name = "cliente")
public class ClienteEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cod_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nom_cliente")
    @NotEmpty
    @Size(min = 2, max = 50, message = "El nombre tiene que estar entre {min} y {max} caracteres")
    private String nombre;

    @Column(name = "apell_paterno_cliente")
    @NotEmpty
    @Size(min = 2, max = 50, message = "El apellido paterno tiene que estar entre {min} y {max} caracteres")
    private String apellidopaterno;

    @Column(name = "apell_materno_cliente")
    @NotEmpty
    @Size(min = 2, max = 50, message = "El apellido materno tiene que estar entre {min} y {max} caracteres")
    private String apellidomaterno;

    @Column(name = "doc_cliente")
    @NotEmpty
    @Size(min = 8, max = 15, message = "El número de documento tiene que estar entre {min} y {max} caracteres")
    private String numerodocumento;

    @Column(name = "fecha_cliente")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;

    @Column(name = "dire_cliente")
    @NotEmpty
    @Size(min = 5, max = 100, message = "La dirección tiene que estar entre {min} y {max} caracteres")
    private String direccion;

    @Column(name = "telefono_cliente")
    @Size(max = 7, message = "El teléfono puede tener hasta {max} caracteres")
    private String telefono;

    @Column(name = "celular_cliente")
    @Size(max = 9, message = "El celular puede tener hasta {max} caracteres")
    private String celular;

    @Column(name = "correo_cliente")
    @NotEmpty
    @Email(message = "El correo debe ser válido")
    private String correo;

    @Column(name = "sexo_cliente")
    @NotEmpty
    @Size(min = 1, max = 1, message = "El sexo debe ser 'M' o 'F'")
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "cod_tipo_documento", nullable = false)
    private TipoDocumentoEntity tipodocumento;

    @ManyToOne
    @JoinColumn(name = "cod_distrito", nullable = false)
    private DistritoEntity distrito;
}

