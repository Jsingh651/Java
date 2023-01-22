package com.jang.ProductsAndCategories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jang.ProductsAndCategories.models.Project;
import com.jang.ProductsAndCategories.models.User;

@Repository
public interface ProjectRepository extends CrudRepository <Project, Long> {
List<Project> findAll();
//List<Project> findAllByMembers(User user);
List<Project> findByMembersNotContains(User user);

@Query("SELECT p FROM Project p WHERE p.lead.id = :userId OR :userId MEMBER OF p.members")
List<Project> findByLeadOrMember(@Param("userId") Long userId);
}


