package com.stratobar.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stratobar.backend.model.Product; // Cambiado de "Student" a "Product"
import com.stratobar.backend.repository.ProductRepository; // Cambiado de "StudentRepository" a "ProductRepository"


@RequestMapping(value = "/Product", produces = MediaType.APPLICATION_JSON_VALUE) // Cambiado de "/Student" a "/Product"
@CrossOrigin(value = "*")
@RestController
public class ProductController { // Cambiado de "StudenController" a "ProductController"

    @Autowired
    private ProductRepository productRepository; // Cambiado de "StudentRepository" a "ProductRepository"

    @GetMapping(value = "/")
    public List<Product> Product() { // Cambiado de "Student" a "Product"
        return productRepository.getAll(); // Cambiado de "getAll" a "getAllProducts"
    }

    @GetMapping(value = "/{state}")
    public List<Product> ProductByState(@PathVariable int state) { // Cambiado de "Student" a "Product"
        return productRepository.getAllbyState(state);

    }

    @PostMapping(value = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody Product product) { // Cambiado de "Student" a "Product"
        productRepository.insert(product); // Cambiado de "insert" a "insertProduct"
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        productRepository.delete(id);
    }

    @PostMapping(value = "/modificar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void modifyProduct(@RequestBody Product product) { // Cambiado de "Student" a "Product"
        productRepository.update(product); // Cambiado de "update" a "updateProduct"
    }

    @PostMapping(value = "/activate/{id}")
    public void activate(@PathVariable String id) {
        productRepository.activate(id);
    }

    @GetMapping(value = "/buscar")
    public List<Product> search(@RequestParam(name = "name") String name,
                                @RequestParam(name = "description") String description,
                                @RequestParam(name = "typeproduct") String typeproduct) {
        Product bean = new Product(); // Cambiado de "Student" a "Product"
        bean.setName(name);
        bean.setDescription(description); // Cambiado de "setLast_name" a "setLastName"
        bean.setType_product(typeproduct); // Cambiado de "setNumber_document" a "setNumberDocument"
        return productRepository.get(bean); // Cambiado de "get" a "getProduct"
    }

}
