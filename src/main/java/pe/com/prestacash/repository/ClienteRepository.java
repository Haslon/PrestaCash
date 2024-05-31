package pe.com.prestacash.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.prestacash.model.ClienteEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface ClienteRepository extends BaseRepository<ClienteEntity, Long> {

    @Query("select c from ClienteEntity c where c.estado=true")
    List<ClienteEntity> findAllCustom();

}
