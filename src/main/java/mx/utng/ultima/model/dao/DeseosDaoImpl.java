package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Deseos;

@Repository
public class DeseosDaoImpl implements IDeseosDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Deseos> list() {
        return em.createQuery("from Deseos").getResultList();
    }

    @Override
    public void save(Deseos deseos) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(deseos.getId() != null && deseos.getId()>0){
            em.merge(deseos);
        }else{
            //Registro nuevo al usar persist
            em.persist(deseos);
        }
    }

    @Override
    public Deseos getById(Long id) {
        return em.find(Deseos.class, id);
    }

    @Override
    public void delete(Long id) {
      Deseos deseos = getById(id);
      em.remove(deseos);
    }
    

}
