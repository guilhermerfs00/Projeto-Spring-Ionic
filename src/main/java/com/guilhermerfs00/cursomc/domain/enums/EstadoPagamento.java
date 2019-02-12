package com.guilhermerfs00.cursomc.domain.enums;

public enum EstadoPagamento{

	CANCELADO(1, "Cancelado"),
	PENDENTE(2, "Pendente"),
	QUITADO(3, "Quitado");
	

	private int cod;
	private String descricao;

	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido" + cod);
	}
}
