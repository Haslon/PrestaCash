package pe.com.prestacash.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.prestacash.model.EmpleadoEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface EmpleadoRepository extends BaseRepository<EmpleadoEntity, Long> {

    @Query("select e from EmpleadoEntity e where e.estado=true")
    List<EmpleadoEntity> findAllCustom();

}
