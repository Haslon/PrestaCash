package pe.com.prestacash.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.prestacash.model.AlmacenEntity;
import pe.com.prestacash.repository.AlmacenRepository;
import pe.com.prestacash.service.AlmacenService;

@Service
public class AlmacenServiceImpl implements AlmacenService {

    @Autowired
    private AlmacenRepository repositorio;

    @Override
    public List<AlmacenEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<AlmacenEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<AlmacenEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public AlmacenEntity add(AlmacenEntity t) {
        return repositorio.save(t);
    }

    @Override
    public AlmacenEntity update(AlmacenEntity t) {
        AlmacenEntity obj = repositorio.getById(t.getCodigoalm());
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public AlmacenEntity delete(AlmacenEntity t) {
        AlmacenEntity obj = repositorio.getById(t.getCodigoalm());
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public AlmacenEntity enable(AlmacenEntity t) {
        AlmacenEntity obj = repositorio.getById(t.getCodigoalm());
        obj.setEstado(true);
        return repositorio.save(obj);
    }

}
