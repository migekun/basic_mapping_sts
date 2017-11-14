package org.formacio.setmana1.data;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.formacio.setmana1.domini.Llibre;
import org.formacio.setmana1.domini.Recomanacio;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LlibreOpsBasic {
	
	@PersistenceContext
	private EntityManager em;
	
	public Llibre carrega (String isbn) throws LlibreNoExisteixException {
		Llibre llibre = em.find(Llibre.class, isbn);
		if (llibre == null) throw new LlibreNoExisteixException();
		return llibre;
	}
	
	/**
	 * 
	 * @param isbn pk
	 * @param autor
	 * @param pagines
	 * @param recomanacio
	 * @param titol
	 */
	public void alta (String isbn, String autor, Integer pagines, Recomanacio recomanacio, String titol) {
		Llibre llibre = new Llibre();
		llibre.setIsbn(isbn);
		llibre.setAutor(autor);
		llibre.setPagines(pagines);
		llibre.setRecomanacio(recomanacio);
		llibre.setTitol(titol);
		em.persist(llibre);
	}
	
	/**
	 * @param isbn del llibre a eliminar
	 * @return true si s'ha esborrat el llibre, false si no existia
	 */
	public boolean elimina (String isbn) {
		Llibre llibre = em.find(Llibre.class, isbn);
		if (llibre != null) {
			em.remove(llibre);
			return true;
		}
		return false;
	}
	
	/**
	 * Guarda a bbdd l'estat del llibre indicat
	 */
	public void modifica (Llibre llibre) {
		em.merge(llibre);
	}
	
	/**
	 * Retorna true o false en funcio de si existeix un llibre amb aquest ISBN
	 * (Aquest metode no llanca excepcions!)
	 */
	public boolean existeix (String isbn) {
		Llibre llibre = em.find(Llibre.class, isbn);
		return (llibre != null);
	}

	/**
	 * Retorna quina es la recomanacio per el llibre indicat
	 * Si el llibre indicat no existeix, retorna null
	 */
	public Recomanacio recomenacioPer (String isbn) {
		Llibre llibre = em.find(Llibre.class, isbn);
		if (llibre != null)
			return llibre.getRecomanacio();
		return null;
	}
	
}
