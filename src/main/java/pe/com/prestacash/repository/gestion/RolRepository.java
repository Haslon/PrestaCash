package pe.com.prestacash.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.prestacash.model.gestion.RolEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface RolRepository extends BaseRepository<RolEntity, Long> {

    @Query("select r from RolEntity r where r.estado=true")
    List<RolEntity> findAllCustom();
} 