package com.example.jpalearn.repository;

import com.example.jpalearn.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class UserRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static List<User> userList = new ArrayList<>();
    private static Long usersCount =0L;
    static {
        userList.add(new User(++usersCount,"Joe","joe@gmail.com", LocalDate.now().minusYears(30),null));
        userList.add(new User(++usersCount,"Jac","jac@gmail.com", LocalDate.now().minusYears(30),null));
        userList.add(new User(++usersCount,"Adam","adam@gmail.com", LocalDate.now().minusYears(30),null));
        userList.add(new User(++usersCount,"Eve","eve@gmail.com", LocalDate.now().minusYears(30),null));

    }
    public List<User> findAll(){
        return userList;
    }
    public User save(User user){
        user.setId(usersCount++);
        userList.add(user);
        return user;
    }
    public User findById(Long id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
       User user =  userList.stream().filter(predicate).findFirst().orElse(null);
       return user;
    }
    public void deleteById(Long id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        userList.removeIf(predicate);
        logger.info("Size after delete {}",userList.size());

    }

}
