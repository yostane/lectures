package org.eclipse.jakarta.ejb;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jakarta.model.CrewMember;

import jakarta.ejb.Stateless;

@Stateless
public class CrewBean {
    static List<CrewMember> crewMembers = new ArrayList<>();

    public void addOne(CrewMember crewMember) {
        crewMembers.add(crewMember);
    }

    public List<CrewMember> getAll() {
        return crewMembers;
    }

    public boolean deleteByName(String name) {
        if (!crewMembers.stream().anyMatch((cm) -> cm.getName().equals(name))) {
            return false;
        }
        crewMembers = crewMembers.stream().filter((cm) -> !cm.getName().equals(name)).toList();
        return true;
    }
}
