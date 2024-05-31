package pe.com.prestacash.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.prestacash.model.AlmacenEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface AlmacenRepository extends BaseRepository<AlmacenEntity, Long> {

    @Query("select a from AlmacenEntity a where a.estado=true")
    List<AlmacenEntity> findAllCustom();

}
