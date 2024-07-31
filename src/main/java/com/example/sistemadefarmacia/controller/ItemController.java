package com.example.sistemadefarmacia.controller;

import com.example.sistemadefarmacia.model.Item;
import com.example.sistemadefarmacia.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;


    @PostMapping(value = "cadastrar")
    @ResponseBody
    public void cadastrar(@RequestBody Item item){
        itemService.cadastrar(item);
    }

    @PutMapping(value = "editar/{codigo}")
    @ResponseBody
    public ResponseEntity<?> editar(@PathVariable("codigo") Long codigo, @RequestBody Item item){
        try{
            item.setCodigo(codigo);
            itemService.editar(codigo, item);
            return ResponseEntity.ok(item);
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Codigo informado invalido ou incorreto");
        }
    }

    @GetMapping(value = "pesquisar/{codigo}")
    @ResponseBody
    public ResponseEntity<Item> pesquisar(@PathVariable("codigo") Long codigo){
            try{
                Item item = itemService.pesquisar(codigo);
                return ResponseEntity.ok(item);
           }catch(Exception e) {
                return ResponseEntity.notFound().build();
           }
    }

    @DeleteMapping(value = "excluir/{codigo}")
    @ResponseBody
    public void excluir(@PathVariable("codigo") Long codigo){
          itemService.excluir(codigo);
    }
}
