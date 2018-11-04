package br.com.unidas.entity;

public enum Motor {
	Motor_1_0("1.0"),
	Motor_1_3("Intermediário"),
	Motor_1_4("Executivo"),
	Motor_1_5("SUV"),
	Motor_1_6("Intermediário"),
	Motor_1_8("Executivo"),
	Motor_2_0("SUV");
	
	public String descricao;

	Motor(String descricao) {
		this.descricao = descricao;
	}
}
