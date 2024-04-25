package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Deseos;



public interface IDeseosDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Deseos> list();

    //Guardar un estudiante
    void save(Deseos deseos);

    //Obterner un estudiante en especifico a partir del id
    Deseos getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


