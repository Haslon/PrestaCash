package pe.com.prestacash.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.prestacash.model.TipoDocumentoEntity;
import pe.com.prestacash.repository.TipoDocumentoRepository;
import pe.com.prestacash.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository repositorio;

    @Override
    public List<TipoDocumentoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<TipoDocumentoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<TipoDocumentoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public TipoDocumentoEntity add(TipoDocumentoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public TipoDocumentoEntity update(TipoDocumentoEntity t) {
        TipoDocumentoEntity obj = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public TipoDocumentoEntity delete(TipoDocumentoEntity t) {
        TipoDocumentoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public TipoDocumentoEntity enable(TipoDocumentoEntity t) {
        TipoDocumentoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(true);
        return repositorio.save(obj);
    }
}
