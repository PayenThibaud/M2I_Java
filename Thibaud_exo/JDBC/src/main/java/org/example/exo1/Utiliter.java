package org.example.exo1;

import java.sql.*;

public class Utiliter {

    public static void ajouterEtudiant(Connection connection, Etudiant etudiant) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO etudiant (nom, prenom, numeroDeClasse, dateDeDiplome) VALUES (?, ?, ?, ?)");
        ps.setString(1, etudiant.getNom());
        ps.setString(2, etudiant.getPrenom());
        ps.setString(3, etudiant.getNumeroDeClasse());
        ps.setString(4, etudiant.getDateDeDiplome());
        ps.executeUpdate();
    }

    public static void afficherLesEtudiants (Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM etudiant");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println("id : " + rs.getString("id") + " nom : " + rs.getString("nom") + " prenom : " + rs.getString("prenom") + " numero de classe : " + rs.getString("numeroDeClasse") + " date de diplome : " + rs.getString("dateDeDiplome"));
        }
    }

    public static void trierEtudiants(Connection connection, Trie trie, String valeur) throws SQLException {
        String requete = "SELECT * FROM etudiant WHERE " + trie.name() + " = ?";
        PreparedStatement ps = connection.prepareStatement(requete);
        ps.setString(1, valeur);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println("id : " + rs.getString("id") + " nom : " + rs.getString("nom") + " prenom : " + rs.getString("prenom") + " numero de classe : " + rs.getString("numeroDeClasse") + " date de diplome : " + rs.getString("dateDeDiplome"));
        }

    }

    public static void retirerEtudiant(Connection connection, int id) throws SQLException {
        String requet = "DELETE FROM etudiant WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(requet);
        ps.setInt(1, id);

        int rowsUpdate = ps.executeUpdate();

        if (rowsUpdate > 0) {
            System.out.println("L'etudiant avec l'ID " + id + " a été supprimer");
        } else {
            System.out.println("Aucun etudiant avec l'ID " + id);
        }
    }
}
