package com.example.sistemadefarmacia.service;

import com.example.sistemadefarmacia.model.Item;

import java.util.List;

public interface ItemService {

    void cadastrar(Item item);

    Item editar(Long codigo, Item item);

    Item pesquisar(Long codigo) throws Exception;

    void excluir(Long codigo);

    List<Item> exibirTudo();
}
