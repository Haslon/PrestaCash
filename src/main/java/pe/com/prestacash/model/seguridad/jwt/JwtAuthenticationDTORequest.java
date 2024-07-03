package pe.com.prestacash.model.seguridad.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationDTORequest {

    private String userName;
    private String password;
    private String name;
    private String email;
    private boolean enable;
    private String[] roles;
}