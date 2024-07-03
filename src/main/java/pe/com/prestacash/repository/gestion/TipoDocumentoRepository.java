package pe.com.prestacash.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.prestacash.model.gestion.TipoDocumentoEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface TipoDocumentoRepository extends BaseRepository<TipoDocumentoEntity, Long> {

    @Query("select t from TipoDocumentoEntity t where t.estado=true")
    List<TipoDocumentoEntity> findAllCustom();

}
