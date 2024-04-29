package com.stratobar.backend.repository;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.stratobar.backend.model.Product;




@Repository
public class ProductRepository implements Crud<Product>{ // Cambiado de "StudentRepository" a "ProductRepository"

    private final String SQL_SELECT_BASE = "SELECT * FROM Product WHERE State = '1' "; // Cambiado de "Student" a "Product"

    private final String SQL_INSERT = "INSERT INTO Product(id, name, description, price, type_product, State) VALUES(?,?,?,?,?,?)"; // Cambiado de "Student" a "Product", eliminados los campos no mencionados

    private final String SQL_DELETE = "UPDATE Product SET state = 0 WHERE ID = ?"; // Cambiado de "student" a "Product"

    private final String SQL_UPDATE = "UPDATE Product SET name = ?, description = ?, price = ?, type_product = ? WHERE id = ?"; // Cambiado de "Student" a "Product", eliminados los campos no mencionados

    private final String SQL_ACTIVATE = "UPDATE Product SET state = 1 WHERE id = ?"; // Cambiado de "student" a "Product"

    @Autowired
    private JdbcTemplate conexion;

    @Override
    public List<Product> getAll() {
        return conexion.query("SELECT * FROM Product WHERE state = 1 ORDER BY ID ASC", BeanPropertyRowMapper.newInstance(Product.class)); // Cambiado de "STUDENT" a "Product"
    }

    @Override
    public List<Product> getAllbyState(int state) {
        return conexion.query("SELECT * FROM Product WHERE state = ? ORDER BY ID ASC",new Object[] { state },new int [] {Types.INTEGER},BeanPropertyRowMapper.newInstance(Product.class)); // Cambiado de "STUDENT" a "Product"
    }

    @Override
    public Product getForId(String id) {
        return conexion.queryForObject("SELECT * FROM Product WHERE ID = ?", Product.class,new Object[] { id }); // Cambiado de "STUDENT" a "Product"
    }

    @Override
    public List<Product> get(Product bean) {
        return conexion.query(SQL_SELECT_BASE + "AND (name = ? or  ? IS NULL ) AND (description = ? or  ? IS NULL ) AND (type_product = ? or  ? IS NULL ) ORDER BY ID ASC",
                new Object[] { bean.getName(),bean.getName(),bean.getDescription(),bean.getDescription(),bean.getType_product(),bean.getType_product() },
                new int [] {Types.NVARCHAR,Types.NVARCHAR,Types.NVARCHAR,Types.NVARCHAR,Types.NVARCHAR,Types.NVARCHAR},
                BeanPropertyRowMapper.newInstance(Product.class));
    }

    @Override
    public void insert(Product bean) {
        var id = conexion.queryForObject("SELECT MAX(ID) as id FROM Product", Integer.class) + 1;
        conexion.update(SQL_INSERT,id,bean.getName(),bean.getDescription(),bean.getPrice(),bean.getType_product(),"1"); // Cambiado de "Student" a "Product"
    }

    @Override
    public void update(Product bean) {
        conexion.update(SQL_UPDATE,bean.getName(),bean.getDescription(),bean.getPrice(),bean.getType_product(),bean.getId()); // Cambiado de "Student" a "Product"
    }

    @Override
    public void delete(String id) {
        conexion.update(SQL_DELETE,id); // Cambiado de "student" a "Product"
    }

    @Override
    public void activate(String id) {
        conexion.update(SQL_ACTIVATE,id); // Cambiado de "student" a "Product"
    }



}
