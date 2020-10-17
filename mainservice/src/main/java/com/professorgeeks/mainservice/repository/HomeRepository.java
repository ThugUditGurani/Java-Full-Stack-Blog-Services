package com.professorgeeks.mainservice.repository;

import com.professorgeeks.mainservice.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home,Long> {

}
