package com.example.assignment_2.Repository;
import com.example.assignment_2.Entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class UserRepository {
    public JdbcTemplate jdbc;
    public UserRepository(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }
    public String GetAll = "SELECT * FROM user";
    public String GetByUsername = "SELECT * FROM user WHERE userName=?";
    public String AddOne = "INSERT INTO user (userName, password, roleId,email ) VALUES (?, ?, ?, ?)";

    public List<User> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(User.class));
    }

    public User getByUsername(String username) {
        return jdbc.queryForObject(GetByUsername, new Object[]{username}, new BeanPropertyRowMapper<>(User.class));
    }

    public void addUser(User user) {
        jdbc.update(AddOne,
                user.userName,
                user.password,
                user.roleId,
                user.email
        );
    }

}
