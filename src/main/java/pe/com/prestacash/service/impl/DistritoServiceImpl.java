package pe.com.prestacash.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.prestacash.model.DistritoEntity;
import pe.com.prestacash.repository.DistritoRepository;
import pe.com.prestacash.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository repositorio;

    @Override
    public List<DistritoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<DistritoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<DistritoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public DistritoEntity add(DistritoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public DistritoEntity update(DistritoEntity t) {
        DistritoEntity obj = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public DistritoEntity delete(DistritoEntity t) {
        DistritoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public DistritoEntity enable(DistritoEntity t) {
        DistritoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(true);
        return repositorio.save(obj);
    }
    
}
