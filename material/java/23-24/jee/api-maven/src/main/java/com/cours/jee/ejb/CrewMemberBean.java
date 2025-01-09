package com.cours.jee.ejb;

import java.util.List;

import com.cours.jee.dao.CrewMemberDao;
import com.cours.jee.model.CrewMember;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class CrewMemberBean {
  @Inject
  CrewMemberDao crewMemberDao;

  public List<CrewMember> getAll() {
    // JPQL (on met les noms des classes au lieu des noms des tables)
    return crewMemberDao.getAll();
  }

  @Transactional
  public void add(CrewMember crewMember) {
    crewMemberDao.add(crewMember);
  }

  public CrewMember getOne(String id) {
    return crewMemberDao.getOne(id);
  }
}
