package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Gastos;

public interface IGastosService {
    List<Gastos> list();
    void save(Gastos gastos);
    Gastos getById(Long id);
    void delete(Long id);
}

