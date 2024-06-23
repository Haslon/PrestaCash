package pe.com.prestacash.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(name = "fecha_init")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechainicio;

    @Column(name = "fecha_end")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechafin;

    @ManyToOne
    @JoinColumn(name = "codcli", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "codemple", nullable = false)
    private EmpleadoEntity empleado;
}
