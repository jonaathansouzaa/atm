package com.atm.enumerations;

public enum NotaEnum {

	NOTA_100(100, "Nota de 100"),
	NOTA_50(50, "Nota de 50"),
	NOTA_20(20, "Nota de 20"),
	NOTA_10(10, "Nota de 10");

	private Integer valor;
	private String descricao;

	NotaEnum(Integer valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public Integer getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

}
