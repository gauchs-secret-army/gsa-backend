package com.example.softwareengineering.repository;
import com.example.softwareengineering.entity.TransactionEntries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TransactionEntryRepository extends JpaRepository<TransactionEntries, Integer> {
}
