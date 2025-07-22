package com.example.jpalearn.rowMapper;

import com.example.jpalearn.Entity.AppUser;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AppUserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        AppUser appUser = new AppUser();
        appUser.setId(rs.getInt("id"));
        appUser.setName(rs.getString("name"));
        appUser.setEmail(rs.getString("email"));
        appUser.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return appUser;

    }
}
