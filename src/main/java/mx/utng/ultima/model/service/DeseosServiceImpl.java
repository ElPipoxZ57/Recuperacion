package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IDeseosDao;
import mx.utng.ultima.model.entity.Deseos;

/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class DeseosServiceImpl implements IDeseosService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IDeseosDao deseosDao;

    @Transactional(readOnly = true)
    @Override
    public List<Deseos> list() {
        return deseosDao.list();
    }

    @Transactional
    @Override
    public void save(Deseos deseos) {
        deseosDao.save(deseos);
    }

    @Transactional(readOnly = true)
    @Override
    public Deseos getById(Long id) {
        return deseosDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        deseosDao.delete(id);
    }
    
}

