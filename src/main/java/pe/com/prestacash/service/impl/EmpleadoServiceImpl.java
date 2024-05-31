package pe.com.prestacash.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.prestacash.model.EmpleadoEntity;
import pe.com.prestacash.repository.EmpleadoRepository;
import pe.com.prestacash.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repositorio;

    @Override
    public List<EmpleadoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<EmpleadoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<EmpleadoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public EmpleadoEntity add(EmpleadoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity t) {
        EmpleadoEntity obj = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public EmpleadoEntity delete(EmpleadoEntity t) {
        EmpleadoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public EmpleadoEntity enable(EmpleadoEntity t) {
        EmpleadoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(true);
        return repositorio.save(obj);
    }
}
