package org.formacio.setmana1.domini;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_LLIBRES")
public class Llibre {

	@Id
	@Column(name = "LLI_ISBN")
	private String isbn;
	
	@Column(name="LLI_TITOL")
	private String titol;
	
	@Column(name="LLI_AUTOR")
	private String autor;
	
	@Column(name="LLI_PAGINES")
	private Integer pagines;

	@Column(name="LLI_RECOMANACIO")
	@Enumerated(EnumType.STRING)
	private Recomanacio recomanacio;
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitol() {
		return titol;
	}
	
	public void setTitol(String titol) {
		this.titol = titol;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Integer getPagines() {
		return pagines;
	}
	
	public void setPagines(Integer pagines) {
		this.pagines = pagines;
	}
	
	public Recomanacio getRecomanacio() {
		return recomanacio;
	}
	
	public void setRecomanacio(Recomanacio recomanacio) {
		this.recomanacio = recomanacio;
	}
}
