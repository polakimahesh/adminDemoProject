package com.dashboard.Admin.Dashboard.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

     List<Users> findAllByOrderByIdAsc();

     Users findByEmailAndEmail(String email, String email1);

}
