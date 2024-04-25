package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Deseos;



public interface IDeseosService {
    List<Deseos> list();
    void save(Deseos deseos);
    Deseos getById(Long id);
    void delete(Long id);
}

