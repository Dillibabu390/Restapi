package com.api.task.repo;

import com.api.task.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    @Query(value = "Select * from user where email=?1 and password=?2",nativeQuery = true)
    User loginuserdb(@PathVariable("email") String email, @PathVariable("password") String password);

}