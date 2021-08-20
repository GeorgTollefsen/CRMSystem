package com.peachy.ppp;
import com.peachy.ppp.entities.CompanyEntity;
import com.peachy.ppp.entities.TeamEntity;
import com.peachy.ppp.services.CompanyService;
import com.peachy.ppp.services.TeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest(classes = TestApplication.class)
public class TeamServiceTest {

    @Autowired
    TeamService teamService;
    @Autowired
    private CompanyService compService;

    @Test
    void should_create_team(){
        CompanyEntity ce = compService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        TeamEntity team = teamService.createTeam("Alpha team", ce);
        assertTrue(!team.getId().toString().isEmpty());
    }

    @Test
    void should_retrieve_all_teams_based_on_company(){
        CompanyEntity ce = compService.createCompany("peach", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        CompanyEntity ce1 = compService.createCompany("Georg", "1234", "håkaleina", "3470", "Oslo", "Ida", "33775606", "idaelto@gmail.com");
        TeamEntity team = teamService.createTeam("Alpha team", ce);
        TeamEntity team2 = teamService.createTeam("Alpha team", ce);
        TeamEntity team3 = teamService.createTeam("Alpha team", ce1);
        assertTrue(teamService.getAllTeamsBasedOnCompany(ce).size() == 2);
    }




}
