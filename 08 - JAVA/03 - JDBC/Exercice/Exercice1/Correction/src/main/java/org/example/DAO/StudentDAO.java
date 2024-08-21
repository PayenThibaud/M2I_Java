package org.example.DAO;

import org.example.Util.DataBaseManager;
import org.example.entity.Student;
import org.postgresql.core.SqlCommand;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String request;

    public StudentDAO() {
        connection = DataBaseManager.getConnection();
    }

    public Student addStudent (Student student){
        try{
            request = "INSERT INTO student (firstname,lastname,class_number,diplome_date) VALUES (?,?,?,?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,student.getFirstname());
            statement.setString(2,student.getLastname());
            statement.setInt(3,student.getClassNumber());
            statement.setDate(4,new Date(student.getDiplomeDate().toEpochDay()));

            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                student.setId(resultSet.getInt(1));
            }

            return student;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            try{
                if(statement!= null && !statement.isClosed()){
                    statement.close();
                }
                if(resultSet != null && !resultSet.isClosed()){
                    resultSet.close();
                }
                request = null;
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Student> getAllStudent(){
        try{
            List<Student> students = new ArrayList<>();
            request = "SELECT * FROM student";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                students.add(Student.builder()
                        .id(resultSet.getInt("id"))
                        .firstname(resultSet.getString("firstname"))
                        .lastname(resultSet.getString("lastname"))
                        .classNumber(resultSet.getInt("class_number"))
                        .diplomeDate(resultSet.getDate("diplome_date").toLocalDate())
                        .build()
                );
            }

            return students;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            try{
                if(statement!= null && !statement.isClosed()){
                    statement.close();
                }
                if(resultSet != null && !resultSet.isClosed()){
                    resultSet.close();
                }
                request = null;
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Student> getAllStudentByClass (int classNumber){
        try{
            List<Student> students = new ArrayList<>();
            request = "SELECT * FROM student WHERE class_number = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1,classNumber);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                students.add(Student.builder()
                        .id(resultSet.getInt("id"))
                        .firstname(resultSet.getString("firstname"))
                        .lastname(resultSet.getString("lastname"))
                        .classNumber(resultSet.getInt("class_number"))
                        .diplomeDate(resultSet.getDate("diplome_date").toLocalDate())
                        .build()
                );
            }

            return students;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
        finally {
            try{
                if(statement!=null && !statement.isClosed())
                    statement.close();
                if(resultSet!=null && !resultSet.isClosed())
                    resultSet.close();
                request = null;
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean deleteStudent (int id){
        try{
            request = "DELETE FROM student WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1,id);

            int row = statement.executeUpdate();

            return row == 1;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }finally {
            try{
                if(statement!=null && !statement.isClosed())
                    statement.close();
                request = null;
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }

    }

}
