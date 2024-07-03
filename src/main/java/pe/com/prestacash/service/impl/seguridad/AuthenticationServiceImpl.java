package pe.com.prestacash.service.impl.seguridad;

import static java.util.Objects.isNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pe.com.prestacash.model.seguridad.jwt.JwtAuthenticationDTOResponse;
import pe.com.prestacash.model.seguridad.jwt.SigninDTORequest;
import pe.com.prestacash.service.seguridad.AuthenticationService;
import pe.com.prestacash.service.seguridad.JwtService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserDetailsService userDetailsService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationDTOResponse signin(SigninDTORequest request) {
        //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        //UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        if (isNull(userDetails)) {
            throw new IllegalArgumentException("Invalid user or password.");
        }

        String jwt = jwtService.generateToken(userDetails);

        return JwtAuthenticationDTOResponse.builder().token(jwt).build();
    }
}