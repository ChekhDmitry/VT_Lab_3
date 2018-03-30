package by.chekh.hotelminsk.dao;

import by.chekh.hotelminsk.bean.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dima on 11/16/2017.
 */
public interface AbstractDAO <T extends Entity> {
    List<T> findAll() throws SQLException;
    void createEntity(T entity) throws SQLException;
    T getEntityById(int id) throws SQLException;
}
