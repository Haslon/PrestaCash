package pe.com.prestacash.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.com.prestacash.model.base.BaseEntity;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "TipoArtefactoEntity")
@Table(name = "tipoartefacto")
public class TipoArtefactoEntity extends BaseEntity implements Serializable {

    private static final long serialVersion = 1L;
    @Id
    @Column(name = "cod_tipo_artefacto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nom_tipo_artefacto")
    @NotEmpty
    @Size(min = 10, max = 60, message = "El nombre del tipo de artefacto  tiene que estar entre {min} y {max}")
    private String nombre;
}
