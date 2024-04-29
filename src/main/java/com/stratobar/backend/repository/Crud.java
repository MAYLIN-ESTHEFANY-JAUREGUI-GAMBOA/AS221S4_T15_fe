package com.stratobar.backend.repository;

import com.stratobar.backend.model.Product;

import java.util.List;

public interface Crud<T> {

    /**
     * Consulta todos los registros de la tabla.
     *
     * @return Retorna una lista.
     */
    List<T> getAll();

    /**
     * Consulta todos los registros de la tabla.
     *
     * @return Retorna una lista.
     */
    List<T> getAllbyState(int state);
    /**
     * Retorna un registro basado en el id.
     *
     * @param id
     * @return
     */
    T getForId(String id);

    /**
     * Consulta datos en base a un criterio.
     *
     * @param bean Datos para establecer el criterio.
     * @return Retorna una lista.
     */
    List<T> get(T bean);

    /**
     * Insertar nuevo registro.
     *
     * @param bean Datos del nuevo registro.
     */
    void insert(T bean);

    /**
     * Actualiza datos de un registro especifico.
     *
     * @param bean Datos del registro.
     */
    void update(T bean);

    /**
     * Elimina un registro de la base de datos.
     *
     * @param id El id del registro a eliminar.
     */
    void delete(String id);

    void activate(String id);


}
