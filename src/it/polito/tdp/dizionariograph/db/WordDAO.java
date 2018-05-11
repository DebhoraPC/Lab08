package it.polito.tdp.dizionariograph.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.dizionariograph.model.Parola;

public class WordDAO {
	
	public WordDAO() {
		
	}

	/*
	 * Ritorna tutte le parole di una data lunghezza
	 */
	public List<Parola> getAllWordsFixedLength(int length) {

		String sql = "SELECT nome FROM parola WHERE LENGTH(nome) = ?";
		List<Parola> parole = new ArrayList<Parola>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, length);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				parole.add(new Parola(res.getString("nome"), length));
			}
			
			st.close();
			conn.close();
			return parole;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error Connection Database");
		}
		
	}
	
	public List<Parola> paroleSimili(String parolaSenzaLettera) {
		
		String sql = "SELECT nome FROM parola WHERE nome LIKE ?";
		List<Parola> risultato = new ArrayList<Parola>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parolaSenzaLettera);
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				risultato.add(new Parola(res.getString("nome"), parolaSenzaLettera.length()));
			}
			
			st.close();
			conn.close();
			return risultato;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
