package it.polito.tdp.dizionariograph.model;

public class Parola {
	
	private String nome;
	private int numeroLettere;
	private int degree;
	
	public Parola() {
		
	}
	
	public Parola(int degree) {
		this.degree = degree;
	}
	
	public Parola(String nome, int numeroLettere) {
		this.nome = nome;
		this.numeroLettere = numeroLettere;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumLettere() {
		return numeroLettere;
	}

	public void setNumLettere(int numeroLettere) {
		this.numeroLettere = numeroLettere;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public boolean differFromOne(Parola p) {
		
		int count = 0;
		
		for (int i = 0; i < this.numeroLettere; i++) {
			if (this.getNome().charAt(i) != p.getNome().charAt(i))
				count++;
		}
		
		if (count == 1)
			return true;
		else
			return false;
	
	}
	
}
