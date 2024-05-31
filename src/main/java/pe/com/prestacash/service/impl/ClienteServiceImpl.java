package pe.com.prestacash.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.prestacash.model.ClienteEntity;
import pe.com.prestacash.repository.ClienteRepository;
import pe.com.prestacash.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repositorio;

    @Override
    public List<ClienteEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ClienteEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<ClienteEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public ClienteEntity add(ClienteEntity t) {
        return repositorio.save(t);
    }

    @Override
    public ClienteEntity update(ClienteEntity t) {
        ClienteEntity obj = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public ClienteEntity delete(ClienteEntity t) {
        ClienteEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public ClienteEntity enable(ClienteEntity t) {
        ClienteEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(true);
        return repositorio.save(obj);
    }
}
