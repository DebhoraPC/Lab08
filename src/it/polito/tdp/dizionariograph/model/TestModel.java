package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.createGraph(4);
		System.out.println(String.format("**Grafo creato**\n"));
		
		List<Parola> vicini = model.displayNeighbours("casa");
		System.out.println("Neighbours di casa: " + vicini.toString() + "\n");
		
		System.out.println("Cerco il vertice con grado massimo...");
		System.out.println(model.findMaxDegree());
		
		// ESEMPIO TESTO: DIZIONARIO DI 4 LETTERE
		
		List<Parola> dizionario = new ArrayList<>();
		
//		dizionario.add(new Parola("casa", 4));
//		dizionario.add(new Parola("case", 4));
//		dizionario.add(new Parola("cara", 4));
//		dizionario.add(new Parola("care", 4));
//		dizionario.add(new Parola("caro", 4));
//		dizionario.add(new Parola("cure", 4));
//		dizionario.add(new Parola("fila", 4));
//		dizionario.add(new Parola("file", 4));
//		dizionario.add(new Parola("pile", 4));
//		
//		model.setParole(dizionario);
//		model.createGraph(4);
//		
//		System.out.println(model.getGraph());
//		System.out.println("\n");
//		System.out.println(model.displayNeighbours("casa").toString());  
//		System.out.println("\n");
//		System.out.println("Grado: " + model.findMaxDegree().getDegree() + 
//							", Vertice: " + model.findMaxDegree().getNome() + 
//							", Vicini: " + model.displayNeighbours(model.findMaxDegree().getNome()).toString());
		
	}

}
