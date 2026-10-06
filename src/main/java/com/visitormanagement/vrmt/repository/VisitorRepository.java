package com.visitormanagement.vrmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visitormanagement.vrmt.entity.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}