package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Gastos;


public interface IGastosDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Gastos> list();

    //Guardar un estudiante
    void save(Gastos gastos);

    //Obterner un estudiante en especifico a partir del id
    Gastos getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


