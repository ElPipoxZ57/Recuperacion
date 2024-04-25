package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.ultima.model.dao.ICompraDao;
import mx.utng.ultima.model.entity.Compra;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class CompraServiceImpl implements ICompraService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private ICompraDao compraDao;

    @Transactional(readOnly = true)
    @Override
    public List<Compra> list() {
        return compraDao.list();
    }

    @Transactional
    @Override
    public void save(Compra compra) {
        compraDao.save(compra);
    }

    @Transactional(readOnly = true)
    @Override
    public Compra getById(Long id) {
        return compraDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        compraDao.delete(id);
    }
    
}

