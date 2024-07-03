package pe.com.prestacash.service.seguridad;

import pe.com.prestacash.model.seguridad.jwt.JwtAuthenticationDTOResponse;
import pe.com.prestacash.model.seguridad.jwt.SigninDTORequest;

public interface AuthenticationService {

    JwtAuthenticationDTOResponse signin(SigninDTORequest request);
}