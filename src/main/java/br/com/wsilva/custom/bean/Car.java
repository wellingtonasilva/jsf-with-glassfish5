package br.com.wsilva.custom.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import br.com.wsilva.custom.model.CarEntity;

@Named("car")
@RequestScoped
public class Car {
	private String name;
	private Integer year;
	private Float price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String save() {
		CarEntity entity = new CarEntity();
		entity.setName(name);
		entity.setPrice(price);
		entity.setYear(year);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(entity);
		tx.commit();

		em.close();
		emf.close();

		return "confirmation";
	}
}
