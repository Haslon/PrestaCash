package pe.com.prestacash.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.prestacash.model.DistritoEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface DistritoRepository extends BaseRepository<DistritoEntity, Long> {

    @Query("select d from DistritoEntity d where d.estado=true")
    List<DistritoEntity> findAllCustom();

}
