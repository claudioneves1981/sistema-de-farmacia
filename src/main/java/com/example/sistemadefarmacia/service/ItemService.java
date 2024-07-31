package com.example.sistemadefarmacia.service;

import com.example.sistemadefarmacia.model.Item;

public interface ItemService {

    void cadastrar(Item item);

    void editar(Long codigo, Item item);

    Item pesquisar(Long codigo);

    void excluir(Long codigo);
}
