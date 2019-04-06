package br.com.caelum.auron.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Par {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Participante amigo;
	
	@ManyToOne
	private Participante amigoOculto;
	
	@ManyToOne
	private Sorteio sorteio;

	public Par(Participante amigo, Participante amigoOculto, Sorteio sorteio) {
		super();
		this.amigo = amigo;
		this.amigoOculto = amigoOculto;
		this.sorteio = sorteio;
	}

}
