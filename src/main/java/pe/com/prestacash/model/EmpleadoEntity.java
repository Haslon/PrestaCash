package pe.com.prestacash.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.com.prestacash.model.base.BaseEntity;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "EmpleadoEntity")
@Table(name = "empleado")
public class EmpleadoEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cod_emple")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nom_emple")
    @NotEmpty
    @Size(min = 2, max = 50, message = "El nombre tiene que estar entre {min} y {max} caracteres")
    private String nombre;

    @Column(name = "apep_emple")
    @NotEmpty
    @Size(min = 2, max = 50, message = "El apellido paterno tiene que estar entre {min} y {max} caracteres")
    private String apellidopaterno;

    @Column(name = "apem_emple")
    @NotEmpty
    @Size(min = 2, max = 50, message = "El apellido materno tiene que estar entre {min} y {max} caracteres")
    private String apellidomaterno;

    @Column(name = "doc_emple")
    @NotEmpty
    @Size(min = 8, max = 15, message = "El número de documento tiene que estar entre {min} y {max} caracteres")
    private String numerodocumento;

    
    @Column(name = "fec_emple")
    private LocalDate fechanacimiento;

    @Column(name = "dire_emple")
    @NotEmpty
    @Size(min = 5, max = 100, message = "La dirección tiene que estar entre {min} y {max} caracteres")
    private String direccion;

    @Column(name = "tel_emple")
    @Size(max = 15, message = "El teléfono puede tener hasta {max} caracteres")
    private String telefono;

    @Column(name = "cel_emple")
    @Size(max = 15, message = "El celular puede tener hasta {max} caracteres")
    private String celular;

    @Column(name = "correo_emple")
    @NotEmpty
    @Email(message = "El correo debe ser válido")
    private String correo;

    @Column(name = "sex_emple")
    @NotEmpty
    @Size(min = 1, max = 1, message = "El sexo debe ser 'M' o 'F'")
    private String sexo;
    
    @ManyToOne
    @JoinColumn(name = "cod_tipo_documento", nullable = false)
    private TipoDocumentoEntity tipodocumento;
    
    @ManyToOne
    @JoinColumn(name = "cod_distrito", nullable = false)
    private DistritoEntity distrito;

    @ManyToOne
    @JoinColumn(name = "cod_cargo", nullable = false)
    private CargoEntity cargo;
}

