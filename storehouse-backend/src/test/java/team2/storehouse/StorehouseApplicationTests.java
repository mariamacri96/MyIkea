package team2.storehouse;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import team2.storehouse.data.dao.*;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.dto.ProfileDto;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.*;
import team2.storehouse.data.service.ProductService;
import team2.storehouse.data.service.UserService;
import team2.storehouse.data.service.impl.LogIn;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorehouseApplicationTests {

	@Autowired
	ShelfDao shelfDao;

	@Autowired
	PlaceDao placeDao;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	SubcategoryDao subcategoryDao;

	@Autowired
	VendorDao vendorDao;


	@Autowired
	UserService userService;

	@Autowired
	LogIn logIn;

	@Autowired
	ProductService productService;
	@Test
	public void testUser() {
		UserDto marco = new UserDto();
		marco.setUsername("marcoBellizzi");
		marco.setEmail("marco@gmail.com");
		marco.setPassword("password123");

		ProfileDto profile = new ProfileDto();
		profile.setName("Marco");
		profile.setSurname("Bellizzi");
		profile.setAddress("Cosenza, via ... ");
		profile.setBirthdate(LocalDate.of(1996, 10, 24));
		profile.setFiscalCode("codiceFiscale");
		profile.setGender(Profile.Gender.MALE);
		profile.setPhone(3284686896L);

		UserDto saved = userService.addUser(marco, profile, User.Type.EMPLOYEE);

		Assert.assertTrue(userService.getUsers().size() > 0);

		UserDto logged = logIn.verify("marcoBellizzi", "password123");

	}

	@Test
	public void testProduct() {
		ProductDto product = new ProductDto();
		product.setName("wood table 1");
		product.setBrand("wood_company");
		product.setPrice(150.00);

		Place place = new Place();
		place.setShelf(shelfDao.save(new Shelf()));
		placeDao.save(place);

		Category category = new Category();
		category.setName("carpentry");
		Subcategory subcategory = new Subcategory();
		subcategory.setName("wood table");
		subcategory.setCategory(categoryDao.save(category));
		product.setSubcategoryName(subcategoryDao.save(subcategory).getName());

		Vendor vendor = new Vendor();
		vendor.setName("wood_company s.r.l.");
		vendor.setVATNumber("VATNUMBER123");
		vendor.setEmail("woodcompany@gmail.com");
		vendor.setPhone(33954841L);
		product.setVendorId(vendorDao.save(vendor).getId());

		ProductDto saved = productService.addProduct(product, place.getId(), 5);

		Assert.assertTrue(productService.getProducts().size() > 0);

	}

}
