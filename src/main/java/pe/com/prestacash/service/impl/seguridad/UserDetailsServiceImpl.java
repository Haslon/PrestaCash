package pe.com.prestacash.service.impl.seguridad;

import static java.util.Objects.isNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.com.prestacash.model.seguridad.UserDetailsCustom;
import pe.com.prestacash.model.seguridad.UserEntity;
import pe.com.prestacash.repository.seguridad.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUserName(username);

        if (isNull(userEntity)) {
            throw new UsernameNotFoundException("El usuario " + username + " no existe");
        }
        return new UserDetailsCustom(userEntity);
    }
}

