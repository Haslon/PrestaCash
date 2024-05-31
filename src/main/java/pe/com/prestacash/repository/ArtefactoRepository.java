package pe.com.prestacash.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.prestacash.model.ArtefactoEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface ArtefactoRepository extends BaseRepository<ArtefactoEntity, Long> {

    @Query("select a from ArtefactoEntity a where a.estado=true")
    List<ArtefactoEntity> findAllCustom();

}