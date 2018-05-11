package it.polito.tdp.dizionariograph.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.dizionariograph.db.WordDAO;

public class Model {
	
	private List<Parola> parole;
	private Graph<Parola, DefaultEdge> graph;
	
	public Model() {
		
	}

	public void createGraph(int numeroLettere) {
		
		WordDAO dao = new WordDAO();
		this.parole = dao.getAllWordsFixedLength(numeroLettere);
		
		this.graph = new SimpleGraph<>(DefaultEdge.class);
		
		Graphs.addAllVertices(this.graph, this.parole);
		
		// aggiungo un link fra due parole solo se differiscono per una SOLA lettera (in Java)
		
		for (Parola p1 : parole) {
			for (Parola p2 : parole) {
				if (!p1.equals(p2) && p1.differFromOne(p2)) 
					this.graph.addEdge(p1, p2);
			}
		}
		
		// aggiungo un link fra due parole solo se differiscono per una SOLA lettera (in SQL): MOLTO LENTO DEVO ARRESTARLO MANUALMENTE
		
//		List<Parola> simili;
//		
//		for (Parola p1 : parole) {
//			for (int i = 0; i < p1.getNome().length(); i++) {
//				StringBuilder nuovap1 = new StringBuilder(p1.getNome());
//				nuovap1.setCharAt(i, '_'); 
//				simili = dao.paroleSimili(nuovap1.toString());
//				for (Parola p2 : simili) {
//					if (!p2.equals(p1) && !contieneLinkFraParole(p1, p2))
//						this.graph.addEdge(p1, p2); 
//				}
//			}
//		}
		
	}

	public List<Parola> displayNeighbours(String parolaInserita) {
		
		Parola parolaDaCercare = new Parola(parolaInserita, parolaInserita.length());
		List<Parola> vicini = Graphs.neighborListOf(this.graph, parolaDaCercare);
		
		return vicini;
		
	}

	public Parola findMaxDegree() {
		
		int bestDegree = 0;
		Parola ris = new Parola(bestDegree);
		
		
		for (Parola p : parole) {
			int degree = this.graph.degreeOf(p);
			if (bestDegree < degree) {
				bestDegree = degree; 
				ris.setDegree(degree); ris.setNome(p.getNome()); ris.setNumLettere(p.getNumLettere());
			}	
		}
		
		return ris;
		
	}
	
	public Boolean contieneParola(String parola) {
		Parola parolaDacercare = new Parola(parola, parola.length()); 
		return this.graph.containsVertex(parolaDacercare);
	}
	
	public Boolean contieneLinkFraParole(Parola parola1, Parola parola2) {
		
		DefaultEdge edgeDaCercare = this.graph.getEdge(parola1, parola2);
		if (edgeDaCercare == null)
			return false;
		else 
			return true;
		
	}
	
	public List<Parola> getParole() {
		return parole;
	}

	public void setParole(List<Parola> parole) {
		this.parole = parole;
	}
	
	public Graph<Parola, DefaultEdge> getGraph() {
		return graph;
	}

	public void setGraph(Graph<Parola, DefaultEdge> graph) {
		this.graph = graph;
	}
	
}
