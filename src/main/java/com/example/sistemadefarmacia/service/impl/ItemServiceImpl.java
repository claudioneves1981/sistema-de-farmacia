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
    public void editar(Long codigo, Item item) {
        Optional<Item> itemBd = itemRepository.findById(codigo);
        Item itematualizado = itemBd.get();
        if(itemBd.isPresent()) {
           // itematualizado.setCodigo(codigo);
            itematualizado.setNome(item.getNome());
            itematualizado.setQuantidade(item.getQuantidade());
            itematualizado.setTipo(item.getTipo());
            itemRepository.save(itematualizado);
        }
    }

    @Override
    public Item pesquisar(Long codigo) {
           return itemRepository.findById(codigo).get();
    }

    @Override
    public void excluir(Long codigo) {
        itemRepository.deleteById(codigo);
    }
}
