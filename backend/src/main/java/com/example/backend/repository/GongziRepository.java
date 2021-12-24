package com.example.backend.repository;

import com.example.backend.entity.Gongzi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GongziRepository extends JpaRepository<Gongzi, Long> {

    Optional<Gongzi> findByGongziNo(Long gongziNo);
}
