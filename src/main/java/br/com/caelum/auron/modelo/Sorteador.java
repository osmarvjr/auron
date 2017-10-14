package br.com.caelum.auron.modelo;

import java.util.Collections;
import java.util.List;

public class Sorteador {

	private Sorteio sorteio;
	private List<Participante> participantes;
	private int totalDeParticipantes;

	public Sorteador(Sorteio sorteio, List<Participante> participantes) throws SorteioException {
		if(participantes == null) {
			throw new SorteioException("Por favor, insira uma lista de participantes");
		}
		this.sorteio = sorteio;
		this.participantes = participantes;
		totalDeParticipantes = participantes.size();
	}

	public void sortear() throws SorteioException {
		totalDeParticipantes = participantes.size();
		verificaTamanhoDaListaDeParticipantes();
		
		embaralhaParticipantes();
		int indiceAtual = 0;
		
		while(indiceAtual < totalDeParticipantes) {
			if(participanteAtualEOUltimo(indiceAtual)) {
				criaEAdicionaOParNoSorteio(sorteio, indiceAtual, 0);
				break;
			}
			criaEAdicionaOParNoSorteio(sorteio, indiceAtual, indiceAtual +1);
			indiceAtual++;
		}
	}

	private void embaralhaParticipantes() {
		Collections.shuffle(participantes);
	}

	private void verificaTamanhoDaListaDeParticipantes() throws SorteioException {
		if(totalDeParticipantes<2) {
			throw new SorteioException("Por favor, insira uma lista de participantes com no minimo dois participantes");
		}
	}

	private boolean participanteAtualEOUltimo(int indiceAtual) {
		return indiceAtual == totalDeParticipantes -1;
	}

	private void criaEAdicionaOParNoSorteio(Sorteio sorteio, int indiceAtual, int indiceFinal) {
		Par par = new Par(participantes.get(indiceAtual), participantes.get(indiceFinal), sorteio);
		sorteio.adicionaPar(par);
	}

}
