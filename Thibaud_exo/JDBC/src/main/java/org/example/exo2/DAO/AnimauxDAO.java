package org.example.exo2.DAO;

import org.example.exo2.entity.Animaux;
import org.example.exo2.enums.AnimauxEnum;
import org.example.exo2.util.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimauxDAO {
    private final Connection conn;

    public AnimauxDAO() {
        this.conn = DatabaseManager.getConnection();
    }

    public Animaux enregistrementAnimaux(Animaux animaux) throws SQLException {
        try {
            String request = "INSERT INTO animaux (nom, race, description, habitat, age) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, animaux.getNom());
            ps.setString(2, animaux.getRace());
            ps.setString(3, animaux.getDescription());
            ps.setString(4, animaux.getHabitat());
            ps.setInt(5, animaux.getAge());

            int nbrRow = ps.executeUpdate();

            if (nbrRow != 1) {
                conn.rollback();
                return null;
            }

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                animaux.setId(rs.getInt(1));
            }
            conn.commit();
            return animaux;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            conn.rollback();
            return null;
        }
    }

    public Animaux getAnimauxById(int id) throws SQLException {
        try {
            String sql = "SELECT * FROM animaux WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                List<Integer> gardienIdList = getGardienIdByAnimauxId(id);
                return Animaux.builder()
                        .id(rs.getInt("id"))
                        .nom(rs.getString("nom"))
                        .race(rs.getString("race"))
                        .description(rs.getString("description"))
                        .habitat(rs.getString("habitat"))
                        .age(rs.getInt("age"))
                        .gardien_id(gardienIdList)
                        .repas(new RepasDAO().getAllRepasByIdAnimaux(rs.getInt("id")))
                        .build();
            }

            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Animaux> getAnimaux(AnimauxEnum animauxEnum, String valeur) throws SQLException {
        List<Animaux> animauxList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM animaux WHERE " + animauxEnum.toString() + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, valeur);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                List<Integer> gardienIdList = getGardienIdByAnimauxId(rs.getInt("id"));

                animauxList.add(Animaux.builder()
                        .id(rs.getInt("id"))
                        .nom(rs.getString("nom"))
                        .race(rs.getString("race"))
                        .description(rs.getString("description"))
                        .habitat(rs.getString("habitat"))
                        .age(rs.getInt("age"))
                        .gardien_id(gardienIdList)
                        .repas(new RepasDAO().getAllRepasByIdAnimaux(rs.getInt("id")))
                        .build());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return animauxList;
    }

    public List<Integer> getGardienIdByAnimauxId(int animauxId) throws SQLException {
        List<Integer> gardienIdList = new ArrayList<>();
        try {
            String sql = "SELECT gardien_id FROM animaux_gardien WHERE animaux_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, animauxId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                gardienIdList.add(rs.getInt("gardien_id"));
            }

            return gardienIdList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }



}

