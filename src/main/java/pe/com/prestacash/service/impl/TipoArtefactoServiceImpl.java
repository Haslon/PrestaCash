package pe.com.prestacash.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.prestacash.model.TipoArtefactoEntity;
import pe.com.prestacash.repository.TipoArtefactoRepository;
import pe.com.prestacash.service.TipoArtefactoService;

@Service
public class TipoArtefactoServiceImpl implements TipoArtefactoService {

    @Autowired
    private TipoArtefactoRepository repositorio;

    @Override
    public List<TipoArtefactoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<TipoArtefactoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<TipoArtefactoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public TipoArtefactoEntity add(TipoArtefactoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public TipoArtefactoEntity update(TipoArtefactoEntity t) {
        TipoArtefactoEntity obj = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public TipoArtefactoEntity delete(TipoArtefactoEntity t) {
        TipoArtefactoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public TipoArtefactoEntity enable(TipoArtefactoEntity t) {
        TipoArtefactoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(true);
        return repositorio.save(obj);
    }
}