package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Compra;

@Repository
public class CompraDaoImpl implements ICompraDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Compra> list() {
        return em.createQuery("from Compra").getResultList();
    }

    @Override
    public void save(Compra compra) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(compra.getId() != null && compra.getId()>0){
            em.merge(compra);
        }else{
            //Registro nuevo al usar persist
            em.persist(compra);
        }
    }

    @Override
    public Compra getById(Long id) {
        return em.find(Compra.class, id);
    }

    @Override
    public void delete(Long id) {
      Compra compra = getById(id);
      em.remove(compra);
    }
    

}
