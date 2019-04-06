package br.com.caelum.auron.modelo;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Sorteio {
	@Id @Getter @Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Getter @Setter
	private String nome;
	
	@OneToMany(mappedBy="sorteio")
	private Set<Par> pares = new LinkedHashSet<>();

	public Set<Par> getPares() {
		return Collections.unmodifiableSet(pares);
	}

	public void setPares(Set<Par> pares) {
		this.pares = pares;
	}

	public void adicionaPar(Par par) {
		this.pares.add(par);
	}

	public int getQuantidadeDePares() {
		return pares.size();
	}
}
