package custom;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import br.com.wsilva.custom.model.CarEntity;

public class TestCar 
{
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
	private EntityManager entityManager;
	private EntityTransaction transaction;

	@Before
	public void initEntityManager() {
		entityManager = emf.createEntityManager();
		transaction = entityManager.getTransaction();
	}
	
	@After
	public void closeEntityManager() {
		if (entityManager != null) {
			entityManager.close();
		}
	}
	
	@Test
	public void createAndSaveCar() 
	{
		CarEntity entity = new CarEntity();
		entity.setName("Test");
		entity.setPrice(10.20f);
		entity.setYear(2012);
		
		//Inicia transação
		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();
		
		assertNotNull("Id. não pode ser null", entity.getId());
		
		//Localizar todos os carros
		List<CarEntity> list = entityManager.createNamedQuery("findAllCar", CarEntity.class).getResultList();
		assertNotNull(list);
	}
}
