package db.dao;

import entities.models.Transformation;

import java.sql.ResultSet;
import java.util.List;

public interface TransformationDao {
    public void add (Transformation form);
    public Transformation findById(int id);
    public Transformation findByForm(Transformation form);
    public List<Transformation> findAll();
    public void deleteById(int id);
    public Transformation instantiateForm(ResultSet resultSet);
}
