package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Gastos;

@Repository
public class GastosDaoImpl implements IGastosDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Gastos> list() {
        return em.createQuery("from Gastos").getResultList();
    }

    @Override
    public void save(Gastos gastos) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(gastos.getId() != null && gastos.getId()>0){
            em.merge(gastos);
        }else{
            //Registro nuevo al usar persist
            em.persist(gastos);
        }
    }

    @Override
    public Gastos getById(Long id) {
        return em.find(Gastos.class, id);
    }

    @Override
    public void delete(Long id) {
      Gastos gastos = getById(id);
      em.remove(gastos);
    }
    

}
