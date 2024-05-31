package pe.com.prestacash.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.prestacash.model.TipoDocumentoEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface TipoDocumentoRepository extends BaseRepository<TipoDocumentoEntity, Long> {

    @Query("select t from TipoDocumentoEntity t where t.estado=true")
    List<TipoDocumentoEntity> findAllCustom();

}
