package com.projetoportefolio.ProjetoPortefolio.Repository;

import com.projetoportefolio.ProjetoPortefolio.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);
    public boolean existsByEmail(String email);
    public boolean existsByPhoneNumber(String phoneNumber);


    @Query(value = "select * from bootspringjavatest.User where email = :email and password = :password", nativeQuery = true)
    public User login(String email, String password);



}
