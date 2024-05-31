package pe.com.prestacash.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.prestacash.model.TipoArtefactoEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface TipoArtefactoRepository extends BaseRepository<TipoArtefactoEntity, Long> {

    @Query("select tp from TipoArtefactoEntity tp where tp.estado=true")
    List<TipoArtefactoEntity> findAllCustom();
}