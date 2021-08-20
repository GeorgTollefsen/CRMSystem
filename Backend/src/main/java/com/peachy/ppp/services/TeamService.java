package com.peachy.ppp.services;

import com.peachy.ppp.entities.CompanyEntity;
import com.peachy.ppp.entities.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Service
public class TeamService {

    @Autowired
    EntityManager em;

    public TeamEntity createTeam(String teamName, CompanyEntity company){
        TeamEntity te = new TeamEntity();
        te.setTeam_name(teamName);
        te.setTargetCompany(company);
        try{
            em.persist(te);
            return te;
        }catch (Exception e){
            return null;
        }
    }

    public List<TeamEntity> getAllTeamsBasedOnCompany(CompanyEntity ce){
        Query query = em.createQuery("SELECT x from TeamEntity x where x.targetCompany.id=:id");
        query.setParameter("id", ce.getId());
        try {
            return query.getResultList();
        }catch (Exception e){
            return null;
        }
    }
}
