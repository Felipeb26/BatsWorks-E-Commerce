import com.batsworks.e_comerce.connection.UserRepository;
import com.batsworks.e_comerce.entity.Users;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void test_0_SaveUser() {
        Users users = new Users();
        users.setName("felipe batista da silva");
        users.setEmail("felipeb2silva@gmail.com");
        users.setSecret("2626");
        users = repository.create(users);
        assertNotNull(users);
        sleep();
    }

    @Test(expected = PersistenceException.class)
    public void test_1_CreateUserFieldNotSet() {
        Users users = new Users();
        users = repository.save(users);
        sleep();
    }

    @Test
    public void test_2_FindUser() {
        Users users = repository.findOne(1);
        assertNotNull(users);
        sleep();
    }

    @Test
    public void test_3_UpdateUser() {
        Users users = new Users();
        users.setId(1);
        users.setName("felipe batista da silva");
        users.setEmail("felipeb2silva@gmail.com");
        users.setSecret("2626");
        users = repository.update(users);
        assertEquals("2626", users.getSecret());
        sleep();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_4_userNotFound() {
        Users users = repository.findOne(99);
        assertNull(users);
        sleep();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_5_DeleteUser() {
        repository.delete(6);
        sleep();
        Users users = repository.findOne(6);
        assertNull(users);
        sleep();
    }

    @Test(expected = EntityNotFoundException.class)
    public void test_6_DeleteNonExistUsers() {
        repository.delete(58);
        sleep();
    }

    @Test
    public void test_7_UserList() {
        List<Users> users = repository.listAll();
        assertFalse(users.isEmpty());
        sleep();
    }

    @AfterClass
    public static void tearDownClass() {
        manager.close();
        entityManagerFactory.close();
    }


    private static void sleep() {
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
