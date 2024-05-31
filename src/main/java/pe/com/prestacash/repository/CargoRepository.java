package pe.com.prestacash.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.prestacash.model.CargoEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface CargoRepository extends BaseRepository<CargoEntity, Long> {

    @Query("select c from CargoEntity c where c.estado=true")
    List<CargoEntity> findAllCustom();

}
