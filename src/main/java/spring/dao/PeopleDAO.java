package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import spring.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public List<Person> index() {
       // return jdbcTemplate.query("SELECT * FROM people", new BeanPropertyRowMapper<>(Person.class));
        return jdbcTemplate.query("SELECT * FROM people", new PeopleMapper());
    }
    public Person getPerson(int id){
        return jdbcTemplate.query("SELECT * FROM people WHERE id=?", new Object[]{id},new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }
    public void save(Person person){
        jdbcTemplate.update("INSERT INTO people VALUES(?, ?)", person.getId(), person.getName());
    }

    public void edit(Person person){
        jdbcTemplate.update("UPDATE PEOPLE set name = ? WHERE id = ?", person.getName(),person.getId());
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM PEOPLE WHERE id=?", id);


    }

}






//@Component
//public class PeopleDAO {
//    private static Connection connection;
//    private static String URL="jdbc:postgresql://localhost:5433/first_db";
//    private static String username="postgres";
//    private static String password="postgres";
//
//    static{
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            connection = DriverManager.getConnection(URL, username,password);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
//    }
//
//
//
//
//
//    public List<Person> index() {
//       List <Person> people = new ArrayList<>();
////        try {
////            Statement statement = connection.createStatement();
////            ResultSet  resultSet= statement.executeQuery("SELECT * FROM people");
////            while (resultSet.next()){
////                people.add(new Person(resultSet.getInt("id"), resultSet.getString("name")));
////            }
////
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM people");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()){
//                people.add(new Person(resultSet.getInt("id"), resultSet.getString("name")));
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
//        return people;
//    }
//    public Person getPerson(int id){
//        String name="null";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM people WHERE id=?");
//            preparedStatement.setInt(1,id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//            System.out.println(name);
//            name = resultSet.getString("name");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return new Person(id, name);
//    }
//    public void save(Person person){
////        try {
////            Statement statement = connection.createStatement();
////            String SQL = "INSERT INTO PEOPLE VALUES ("+ PEOPLE_COUNT + ", '" + person.getName() + "')";
////            statement.executeUpdate(SQL);
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO people VALUES(?,?)");
//            preparedStatement.setInt(1,PEOPLE_COUNT);
//            preparedStatement.setString(2,person.getName());
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
//    }
//    public void edit(Person person){
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE people SET name=? WHERE id=?");
//            preparedStatement.setString(1,person.getName());
//            preparedStatement.setInt(2, person.getId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
//    }
//
//    public void delete(int id){
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM people WHERE id=?");
//            preparedStatement.setInt(1,id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//    }
//
//}
