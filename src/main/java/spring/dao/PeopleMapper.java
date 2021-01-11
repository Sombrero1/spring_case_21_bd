package spring.dao;

import org.springframework.jdbc.core.RowMapper;
import spring.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleMapper implements RowMapper <Person>{
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Person(resultSet.getInt("id"), resultSet.getString("name"));
    }
}
