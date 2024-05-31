package pe.com.prestacash.model;

import jakarta.persistence.*;
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
@Entity(name = "ContratoEntity")
@Table(name = "contrato")
public class ContratoEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "nro_contrato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;

    @ManyToOne
    @JoinColumn(name = "cod_cliente", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "cod_empleado", nullable = false)
    private EmpleadoEntity empleado;
}

