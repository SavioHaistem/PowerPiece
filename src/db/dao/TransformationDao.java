package db.dao;
import entities.models.Transformation;
import java.sql.ResultSet;
import java.util.List;

public interface TransformationDao {
    void add(Transformation form);
    Transformation findById(int id);
    Transformation findByForm(Transformation form);
    List<Transformation> findAll();
    void deleteById(int id);
    Transformation instantiateForm(ResultSet resultSet);
}
