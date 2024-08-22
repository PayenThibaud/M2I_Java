package org.example.exo2.DAO;


import org.example.exo2.entity.Gardien;
import org.example.exo2.util.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GardienDAO {
    private final Connection conn;

    public GardienDAO() {
        this.conn = DatabaseManager.getConnection();
    }

    public  Gardien Enregistrergardien (Gardien gardien) throws SQLException {
        try {
            String request = "INSERT INTO gardien (nom) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, gardien.getNom());

            int nbrRow = statement.executeUpdate();

            if (nbrRow != 1) {
                conn.rollback();
                return null;
            }
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                gardien.setId(rs.getInt(1));
            }
            conn.commit();
            return gardien;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            conn.rollback();
            return null;
        }
    }

    public Gardien getGardienById(int id) throws SQLException {
        try {
            String sql = "SELECT * FROM gardien WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                List<Integer> animauxIdList = getAnimauxIdByGardienId(id);

                return Gardien.builder()
                        .id(rs.getInt("id"))
                        .nom(rs.getString("nom"))
                        .animaux_id(animauxIdList)
                        .build();
            }

            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Integer> getAnimauxIdByGardienId(int gardienId) throws SQLException {
        List<Integer> animauxIdList = new ArrayList<>();
        try {
            String sql = "SELECT animaux_id FROM animaux_gardien WHERE gardien_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, gardienId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                animauxIdList.add(rs.getInt("animaux_id"));
            }

            return animauxIdList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public void lierAnimauxAuxGardiens(int gardienId, int animalId) throws SQLException {
        try {
            String sql = "INSERT INTO animaux_gardien (gardien_id, animaux_id) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, gardienId);
            ps.setInt(2, animalId);

            int nbrRows = ps.executeUpdate();

            if (nbrRows != 1) {
                conn.rollback();
            }

            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            conn.rollback();
        }
    }






}
