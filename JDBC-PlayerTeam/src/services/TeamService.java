/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.TeamInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Team;
import util.MyConnection;

/**
 *
 * @author HP
 */
public class TeamService  implements TeamInterface{
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addTeam(Team t) {
        try {

            String req = "INSERT INTO `Team`( `id`,`name`, `country`,`stadium`, `division`) VALUES (?,?,?,?,?)";

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, t.getId());
            ps.setString(2, t.getName());
            ps.setString(3, t.getCountry());
            ps.setString(4, t.getStadium());
            ps.setString(5, t.getDivision());

            ps.executeUpdate();
            System.out.println("Team Added Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Team> fetchTeams() {
         List<Team> teams = new ArrayList<>();
        try {

            String req = "SELECT * FROM team";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Team t = new Team();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setCountry(rs.getString(3));
                t.setStadium(rs.getString(4));
                t.setDivision(rs.getString(5));

                teams.add(t);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return teams;
    }

    @Override
    public void deleteTeam(int id) {
         String req = "DELETE FROM `team` WHERE id =?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void updateTeam(int id, Team t) {
        try {
            String req = "UPDATE `team` SET `name`= ?, `division`= ?,`satdium`= ?, `country`= ?   WHERE id = ?";
            PreparedStatement rs = cnx.prepareStatement(req);
            rs.setInt(1, id);
            rs.setString(2, t.getName());
            rs.setString(3, t.getDivision());
            rs.setString(4, t.getStadium());
            rs.setString(5, t.getCountry());
            rs.executeUpdate();
            System.out.println("Team updated successfully!");
        } catch (SQLException ex) {
            System.out.println("not found");
        }

    }

    @Override
    public Team fetchTeams(int id) {
         Team t = new Team();
        try {

            String req = "SELECT * FROM team WHERE ID =? ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setCountry(rs.getString(3));
                t.setStadium(rs.getString(4));
                t.setDivision(rs.getString(5));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return t;
    }
        
    }
   
