package com.PowerPiece.db.dao;
import com.PowerPiece.entities.models.Transformation;
import java.sql.ResultSet;
import java.util.Map;

public interface TransformationDao {
    void add(Transformation form);
    Transformation findById(int id);
    Transformation findByForm(Transformation form);
    Map<Integer, Transformation> findAll();
    void deleteById(int id);
    Transformation instantiateForm(ResultSet resultSet);
}
