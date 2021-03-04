package com.example.softwareengineering.repository;
import com.example.softwareengineering.entity.ActiveEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface ActiveEmployeeRepository extends JpaRepository<ActiveEmployee, Integer> {
    boolean getActiveEmployeeBySessionKey(String sessionKey);
}
