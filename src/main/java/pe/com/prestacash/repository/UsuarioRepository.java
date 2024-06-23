package pe.com.prestacash.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.prestacash.model.UsuarioEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface UsuarioRepository extends BaseRepository<UsuarioEntity, Long> {

    @Query("select u from UsuarioEntity u where u.estado=true")
    List<UsuarioEntity> findAllCustom();

    @Query("select u from UsuarioEntity u where u.nombre=:usu and clave=:cla")
    List<UsuarioEntity> signin(@Param("usu") String usu,@Param("cla") String clave );
}