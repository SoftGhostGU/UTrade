package com.ghost.backend.mapper;

import com.ghost.backend.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from Users where Nickname = #{username}")
    User findByUsername(String username);

    @Insert("insert into Users(Nickname, Email, Password, RegistrationDate)" +
            "values(#{username}, #{email}, #{password}, now())")
    void add(String username, String password, String email);
}
