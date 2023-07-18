import com.batsworks.e_comerce.connection.BatsWorksRepository;
import com.batsworks.e_comerce.entity.Users;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import static org.junit.Assert.assertEquals;

public class JDBCTest {
    private static BatsWorksRepository repository;
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager manager;

    @BeforeClass
    public static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BatsWorks_E_Commerce");
        manager = entityManagerFactory.createEntityManager();
        repository = new BatsWorksRepository(manager);
    }

    @Test
    public void saveUser() {
        Users users = new Users();
        users.setName("felipe batista da silva");
        users.setEmail("felipeb2silva@gmail.com");
        users.setSecret("2626");
        users = repository.create(users);
        TestCase.assertNotNull(users);
    }

    @Test(expected = PersistenceException.class)
    public void testCreateUserFieldNotSet() {
        Users users = new Users();
        users = repository.save(users);
    }

    @Test
    public void testUpdateUser() {
        Users users = new Users();
        users.setId(1);
        users.setName("felipe batista da silva");
        users.setEmail("felipeb2silva@gmail.com");
        users.setSecret("2626");
        users = repository.update(users);
        assertEquals("2626", users.getSecret());
    }


    @AfterClass
    public static void tearDownClass() {
        manager.close();
        entityManagerFactory.close();
    }

}
