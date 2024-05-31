package pe.com.prestacash.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.prestacash.model.ContratoEntity;
import pe.com.prestacash.repository.ContratoRepository;
import pe.com.prestacash.service.ContratoService;

@Service
public class ContratoServiceImpl implements ContratoService {

    @Autowired
    private ContratoRepository repositorio;

    @Override
    public List<ContratoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ContratoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<ContratoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public ContratoEntity add(ContratoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public ContratoEntity update(ContratoEntity t) {
        ContratoEntity obj = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public ContratoEntity delete(ContratoEntity t) {
        ContratoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public ContratoEntity enable(ContratoEntity t) {
        ContratoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(true);
        return repositorio.save(obj);
    }
}
