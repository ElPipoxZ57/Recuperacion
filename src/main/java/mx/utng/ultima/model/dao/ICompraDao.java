package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Compra;



public interface ICompraDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Compra> list();

    //Guardar un estudiante
    void save(Compra compra);

    //Obterner un estudiante en especifico a partir del id
    Compra getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


