package pe.com.prestacash.repository.seguridad;

import pe.com.prestacash.model.seguridad.UserEntity;
import pe.com.prestacash.repository.base.BaseRepository;

public interface UserRepository extends BaseRepository<UserEntity, Long> {
    //como el correo se utilizara para validar se buscar por correo
    //UserEntity findByEmail(String email);

    UserEntity findByUserName(String username);
}