package br.com.caelum.auron.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Participante {

	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String email;
	private String senha;
}
