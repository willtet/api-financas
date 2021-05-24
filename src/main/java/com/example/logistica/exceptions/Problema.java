package com.example.logistica.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class Problema {
	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campo;
	
	
	public Problema(Integer status, LocalDateTime dataHora, String titulo, List<Campo> campo) {
		super();
		this.status = status;
		this.dataHora = dataHora;
		this.titulo = titulo;
		this.campo = campo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	public List<Campo> getCampo() {
		return campo;
	}
	public void setCampo(List<Campo> campo) {
		this.campo = campo;
	}



	static class Campo{
		private String nome;
		private String mensagem;
		
		
		public Campo(String nome, String mensagem) {
			super();
			this.nome = nome;
			this.mensagem = mensagem;
		}
		public String getNome() {
			return nome;
		}
		public String getMensagem() {
			return mensagem;
		}
		
		
		
		
	}
	
	
}
