package team2.storehouse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import team2.storehouse.data.dao.ProfileDao;
import team2.storehouse.data.dao.ShoppingCartDao;
import team2.storehouse.data.entities.Profile;
import team2.storehouse.data.entities.ShoppingCart;
import team2.storehouse.data.entities.User;
import team2.storehouse.data.service.UserService;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorehouseApplicationTests {

	@Autowired
	ProfileDao profileDao;

	@Autowired
	ShoppingCartDao shoppingCartDao;

	@Autowired
	UserService userService;

	@Test
	public void testUser() {    // very simple test to test userService

		User marco = new User();
		marco.setUsername("marcoBellizzi");
		marco.setEmail("marco@gmail.com");
		marco.setPassword("password123");
		marco.setType(User.Type.EMPLOYEE);

		marco.setShoppingCart(shoppingCartDao.save(new ShoppingCart()));

		Profile profile = new Profile();
		profile.setName("Marco");
		profile.setSurname("Bellizzi");
		profile.setAddress("Cosenza, via ... ");
		profile.setBirthdate(LocalDate.of(1996, 10, 24));
		profile.setFiscalCode("codiceFiscale");
		profile.setGender(Profile.Gender.MALE);
		profile.setPhone(3284686896L);

		marco.setProfile(profileDao.save(profile));

		User savedMarco = userService.addUser(marco);

		for(User user : userService.getUsers()) {
			System.out.println(user);
		}

	}

}
