package pe.com.prestacash.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;
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
    @Column(name = "codcli")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nomcli")
    @NotEmpty
    @Size(min = 2, max = 50, message = "El nombre tiene que estar entre {min} y {max} caracteres")
    private String nombre;

    @Column(name = "apepcli")
    @NotEmpty
    @Size(min = 2, max = 50, message = "El apellido paterno tiene que estar entre {min} y {max} caracteres")
    private String apellidopaterno;

    @Column(name = "apemcli")
    @NotEmpty
    @Size(min = 2, max = 50, message = "El apellido materno tiene que estar entre {min} y {max} caracteres")
    private String apellidomaterno;

    @Column(name = "doccli")
    @NotEmpty
    @Size(min = 8, max = 15, message = "El número de documento tiene que estar entre {min} y {max} caracteres")
    private String numerodocumento;

    @Column(name = "feccli")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechanacimiento;

    @Column(name = "dircli")
    @NotEmpty
    @Size(min = 5, max = 100, message = "La dirección tiene que estar entre {min} y {max} caracteres")
    private String direccion;

    @Column(name = "teclcli")
    @Size(max = 7, message = "El teléfono puede tener hasta {max} caracteres")
    private String telefono;

    @Column(name = "celcli")
    @Size(max = 9, message = "El celular puede tener hasta {max} caracteres")
    private String celular;

    @Column(name = "corcli")
    @NotEmpty
    @Email(message = "El correo debe ser válido")
    private String correo;

    @Column(name = "sexcli")
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

