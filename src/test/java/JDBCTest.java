import com.batsworks.e_comerce.connection.UserRepository;
import com.batsworks.e_comerce.entity.Users;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

public class JDBCTest {
    private static UserRepository repository;
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager manager;

    @BeforeClass
    public static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BatsWorks_E_Commerce");
        manager = entityManagerFactory.createEntityManager();
        repository = new UserRepository(manager);
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
    public void testFindUser() {
        Users users = repository.findOne(1);
        assertNotNull(users);
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

    @Test(expected = IllegalArgumentException.class)
    public void userNotFound() {
        Users users = repository.findOne(99);
        assertNull(users);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteUser() {
        repository.delete(3);
        Users users = repository.findOne(3);
        assertNull(users);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testDeleteNonExistUsers(){
        repository.delete(58);
    }

    @Test
    public void testUserList(){
        List<Users> users= repository.listAll();
        assertFalse(users.isEmpty());
    }

    @AfterClass
    public static void tearDownClass() {
        manager.close();
        entityManagerFactory.close();
    }

}
