package com.suock.admin.dao;

import com.suock.admin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    @Query("select u from User u where u.loginName = ?1")
    public User getUserByUserName(String userName);
}
