package com.example.jpalearn.DataAccess;

import com.example.jpalearn.Entity.AppUser;
import com.example.jpalearn.rowMapper.AppUserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppUserRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<AppUser> findAll() {

        //return jdbcTemplate.query("Select * from AppUser", new BeanPropertyRowMapper<>(AppUser.class));
        return jdbcTemplate.query("Select * from AppUser", new AppUserRowMapper());
    }

    public AppUser findById(int id) {
        return jdbcTemplate.queryForObject("Select * from AppUser where id = ?",new BeanPropertyRowMapper<>(AppUser.class),new Object[]{id});
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("Delete from AppUser where id = ?",new Object[]{id});
    }

    public int insert(AppUser appUser) {
        return jdbcTemplate.update("INSERT INTO AppUser (name, email) VALUES(?, ?)",new Object[]{appUser.getName(),appUser.getEmail()});
    }
    public int update(AppUser appUser) {
        return jdbcTemplate.update("UPDATE AppUser SET name = ?, email = ? WHERE id = ?",new Object[]{appUser.getName(),appUser.getEmail(),appUser.getId()});
    }

    //---------------------------------------------------------------------------

    public AppUser findById_(int id) {
        String q = "Select * from AppUser where id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id",id);
        return namedParameterJdbcTemplate.queryForObject(q,parameterSource,new BeanPropertyRowMapper<>(AppUser.class));
    }

    public int insert_(AppUser appUser) {
        String q = "INSERT INTO AppUser (name, email) VALUES(:name, :email)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name",appUser.getName());
        parameterSource.addValue("email",appUser.getEmail());
        return namedParameterJdbcTemplate.update(q,parameterSource);
    }


}

