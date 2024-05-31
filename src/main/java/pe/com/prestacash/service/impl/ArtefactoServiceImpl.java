package pe.com.prestacash.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.prestacash.model.ArtefactoEntity;
import pe.com.prestacash.repository.ArtefactoRepository;
import pe.com.prestacash.service.ArtefactoService;

@Service
public class ArtefactoServiceImpl implements ArtefactoService {

    @Autowired
    private ArtefactoRepository repositorio;

    @Override
    public List<ArtefactoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ArtefactoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<ArtefactoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public ArtefactoEntity add(ArtefactoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public ArtefactoEntity update(ArtefactoEntity t) {
        ArtefactoEntity obj = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public ArtefactoEntity delete(ArtefactoEntity t) {
        ArtefactoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public ArtefactoEntity enable(ArtefactoEntity t) {
        ArtefactoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(true);
        return repositorio.save(obj);
    }

}