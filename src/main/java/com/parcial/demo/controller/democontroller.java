/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parcial.demo.controller;

import com.parcial.demo.modelo.Productos;
import com.parcial.demo.repositorio.ProductoRepositorio;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Oldin Orantes
 */
@RestController
@RequestMapping("/producto")
public class democontroller {
    @Autowired
    ProductoRepositorio productoRepositorio;
    
    @GetMapping("/todos")
    public ResponseEntity<List<Productos>> obtenerTodosProducto() {
        return ResponseEntity.ok((List<Productos>)productoRepositorio.findAll());
    }
    
    @GetMapping("/filtroprecio")        
    public ResponseEntity<List<Productos>> getAll() {
    List<Productos> producto = (List<Productos>) productoRepositorio.findAll();
        
        List<Productos> listaprecio = producto
                .stream()
                .filter(p -> {
            return p.getPrecio() > 10;
        }).collect(Collectors.toList());
        
         return ResponseEntity.ok(listaprecio);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Productos> saveProducto(@RequestBody Productos prod){
               return ResponseEntity.ok(productoRepositorio.save(prod));
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity<Productos> actualizarProducto(@RequestBody Productos prod) {
        return ResponseEntity.ok(productoRepositorio.save(prod));
    }
    
    @DeleteMapping("/borrar")
    public ResponseEntity<Boolean> borrarProducto(@RequestBody Productos prod) {
        productoRepositorio.delete(prod);
        return ResponseEntity.ok(true);
    }
}
