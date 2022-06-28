package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Anagramma;

public class AnagrammaDAO {
	
	public boolean getTutteParole(String parola) {
		
		final String sql = "SELECT id FROM parola WHERE nome = ? ";
		boolean c = false;
		
		try {
			Connection conn =DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				
				c = true;
				
			}
			rs.close();
			st.close();
			conn.close();
			return c;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Errore DB", e);
		}
	}

}
