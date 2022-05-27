package com.example.l13.db;

import com.example.l13.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO<Student,Integer> {
    public StudentDAO(Connection conn) throws SQLException {
        super(conn);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM STUD";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO STUD (NAME,GROUP,STUD_ID,COURSE) VALUES (?, ?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE STUD " +
                "SET NAME = ?, GROUP  = ? ,COURSE=?" +
                "WHERE STUD_ID = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM STUD WHERE STUD_ID = ?;";
    }

    @Override
    protected List<Student> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<Student> result = new ArrayList<Student>();
        while (rs.next()) {
            Student std = new Student();
            std.setId(rs.getInt("id"));
            std.setName(rs.getString("name"));
            std.setGroup(rs.getInt("group"));
            std.setCourse(rs.getInt("course"));
            result.add(std);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Student entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setInt(2, entity.getGroup());
        statement.setInt(3, entity.getCourse());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Student entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setInt(2, entity.getGroup());
        statement.setInt(3, entity.getCourse());
        statement.setInt(4, entity.getId());
    }
}