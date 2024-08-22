package org.example.exo2.DAO;

import org.example.exo2.entity.Repas;
import org.example.exo2.util.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepasDAO {
    private final Connection con;

    public RepasDAO() {
        this.con = DatabaseManager.getConnection();
    }

    public Repas enregistrerRepas(Repas repas) throws SQLException {
        try {
            String request = "INSERT INTO repas (date, heure, detail, animaux_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, repas.getDate());
            ps.setString(2, repas.getHeure());
            ps.setString(3, repas.getDetail());
            ps.setInt(4, repas.getAnimaux_id());
            int nbrRow = ps.executeUpdate();

            if (nbrRow != 1) {
                con.rollback();
                return null;
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                repas.setId(rs.getInt(1));
            }
            con.commit();
            return repas;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            con.rollback();
            return null;
        }
    }

    public List<Repas> getAllRepasByIdAnimaux(int idAnimaux) {
        try {
            String request = "SELECT * FROM repas WHERE animaux_id = ?";
            PreparedStatement ps = con.prepareStatement(request);
            ps.setInt(1, idAnimaux);

            ResultSet rs = ps.executeQuery();

            List<Repas> repas = new ArrayList<>();
            while (rs.next()){
                repas.add(Repas.builder()
                        .id(rs.getInt("id"))
                        .date(rs.getString("date"))
                        .heure(rs.getString("heure"))
                        .detail(rs.getString("detail"))
                        .animaux_id(idAnimaux)
                        .build());
            }

            return repas;

        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
