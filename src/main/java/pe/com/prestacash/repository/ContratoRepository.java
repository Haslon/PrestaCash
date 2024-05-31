package pe.com.prestacash.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.prestacash.model.ContratoEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface ContratoRepository extends BaseRepository<ContratoEntity, Long> {

    @Query("select c from ContratoEntity c where c.estado=true")
    List<ContratoEntity> findAllCustom();

}
