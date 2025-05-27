package br.dev.edvan.elevador.model;

import java.util.ArrayList;

public class Elevador {
	int andarAtual;
	int andarDestino;
	ArrayList<Integer> fila = new ArrayList<Integer>();

	public Elevador() {
		andarAtual = 1;

	}

	private void subir() {
		for (int i = andarAtual ; i != andarDestino; i++) {
			if (andarAtual == andarDestino) {
				atualizarDestino();
			}
		}
	}

	private void descer() {
		andarAtual--;
		
		if (andarAtual == andarDestino) {
			atualizarDestino();
		}
	}

	public void conferirFila(int andar) {
		boolean repetido = false;
		for (int i = 0; i < 3; i++) {
			if (fila.get(i) == andar) {
				repetido = true;
			}
		}
		if (repetido == false) {
			adicionarAFila(andar);
		}
	}

	private void adicionarAFila(int andar) {
		fila.add(andar);
	}
	
	
	private void atualizarDestino() {
		andarDestino = fila.removeFirst();
		if (andarDestino > andarAtual) {
			subir();
		}
		else if (andarDestino < andarAtual) {
			descer();
		}
	}
	

}
