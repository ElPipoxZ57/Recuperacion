package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Compra;



public interface ICompraService {
    List<Compra> list();
    void save(Compra compra);
    Compra getById(Long id);
    void delete(Long id);
}

