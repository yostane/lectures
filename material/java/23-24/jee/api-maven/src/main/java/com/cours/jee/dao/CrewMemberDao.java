package com.cours.jee.dao;

import java.util.List;

import com.cours.jee.model.CrewMember;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class CrewMemberDao {

  @PersistenceContext
  private EntityManager entityManager;

  public List<CrewMember> getAll() {
    // JPQL (on met les noms des classes au lieu des noms des tables)
    return entityManager.createQuery("SELECT cm FROM CrewMember cm", CrewMember.class).getResultList();
  }

  public void add(CrewMember crewMember) {
    entityManager.persist(crewMember);
    entityManager.flush();
  }

  public CrewMember getOne(String id) {
    return entityManager.find(CrewMember.class, id);
  }

}
