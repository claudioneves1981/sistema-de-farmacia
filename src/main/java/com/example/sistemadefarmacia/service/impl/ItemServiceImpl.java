package com.example.sistemadefarmacia.service.impl;

import com.example.sistemadefarmacia.model.Item;
import com.example.sistemadefarmacia.repository.ItemRepository;
import com.example.sistemadefarmacia.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemRepository itemRepository;


    @Override
    public void cadastrar(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item editar(Long codigo, Item item) {
        Optional<Item> itemBd = itemRepository.findById(codigo);
        if(itemBd.isPresent()) {
            item.setCodigo(codigo);
            itemRepository.save(item);
        }
        return item;
    }

    @Override
    public Item pesquisar(Long codigo) throws Exception {
        return itemRepository.findById(codigo).orElseThrow(() -> new Exception("Item não encontrado"));
    }

    @Override
    public void excluir(Long codigo) {
        itemRepository.deleteById(codigo);
    }
}
