package pe.com.prestacash.repository.seguridad;

import org.springframework.stereotype.Repository;
import pe.com.prestacash.model.seguridad.UserEntity;
import pe.com.prestacash.repository.base.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, Long> {

    //como el correo se utilizara para validar se buscar por correo
     UserEntity findByUserName(String user);
}