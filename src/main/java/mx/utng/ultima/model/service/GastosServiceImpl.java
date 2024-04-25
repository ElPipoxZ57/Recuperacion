package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IGastosDao;
import mx.utng.ultima.model.entity.Gastos;

/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class GastosServiceImpl implements IGastosService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IGastosDao gastosDao;

    @Transactional(readOnly = true)
    @Override
    public List<Gastos> list() {
        return gastosDao.list();
    }

    @Transactional
    @Override
    public void save(Gastos gastos) {
        gastosDao.save(gastos);
    }

    @Transactional(readOnly = true)
    @Override
    public Gastos getById(Long id) {
        return gastosDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        gastosDao.delete(id);
    }
    
}

