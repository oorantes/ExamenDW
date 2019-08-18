/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parcial.demo.repositorio;

import com.parcial.demo.modelo.Productos;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Oldin Orantes
 */
public interface ProductoRepositorio 
        extends CrudRepository<Productos, Integer>{
    
}
