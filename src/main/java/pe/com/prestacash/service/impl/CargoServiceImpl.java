package pe.com.prestacash.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.prestacash.model.CargoEntity;
import pe.com.prestacash.repository.CargoRepository;
import pe.com.prestacash.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository repositorio;

    @Override
    public List<CargoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<CargoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<CargoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public CargoEntity add(CargoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public CargoEntity update(CargoEntity t) {
        CargoEntity obj = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public CargoEntity delete(CargoEntity t) {
        CargoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public CargoEntity enable(CargoEntity t) {
        CargoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(true);
        return repositorio.save(obj);
    }
}
