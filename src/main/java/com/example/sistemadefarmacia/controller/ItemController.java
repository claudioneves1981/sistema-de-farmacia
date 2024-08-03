package com.example.sistemadefarmacia.controller;

import com.example.sistemadefarmacia.model.Item;
import com.example.sistemadefarmacia.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
             Item itematualizado = itemService.editar(codigo, item);
             if(itematualizado.getCodigo() == null){
                 return new ResponseEntity<>("Codigo invalido ou item inexistente", HttpStatus.OK);
             }else {
                 return new ResponseEntity<>(itematualizado, HttpStatus.OK);
             }
    }

    @GetMapping(value = "pesquisar/{codigo}")
    @ResponseBody
    public ResponseEntity<?> pesquisar(@PathVariable("codigo") Long codigo){
            try{
                Item item = itemService.pesquisar(codigo);
                return new ResponseEntity<>(item, HttpStatus.OK);
           }catch(Exception e) {
                return new ResponseEntity<>("Item não encontrado", HttpStatus.NOT_FOUND);
            }
    }

    @DeleteMapping(value = "excluir/{codigo}")
    @ResponseBody
    public void excluir(@PathVariable("codigo") Long codigo){
          itemService.excluir(codigo);
    }

    @GetMapping(value = "exibirtudo" )
    @ResponseBody
    public ResponseEntity<List<Item>> exibirTudo(){
        return new ResponseEntity<>(itemService.exibirTudo(), HttpStatus.OK);
    }
}
