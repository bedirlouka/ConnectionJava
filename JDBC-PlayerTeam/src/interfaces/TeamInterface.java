/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Team;

/**
 *
 * @author HP
 */
public interface TeamInterface {
    public void addTeam(Team t);

    public List<Team> fetchTeams(); 
    public void deleteTeam(int id) ;
    
    public void updateTeam(int id ,Team t);
    public Team fetchTeams(int id);
    
}
