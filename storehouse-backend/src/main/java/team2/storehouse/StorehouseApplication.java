package team2.storehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import team2.storehouse.data.dao.*;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.dto.ProfileDto;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.*;
import team2.storehouse.data.service.ProductService;
import team2.storehouse.data.service.UserService;

import java.time.LocalDate;

@SpringBootApplication
public class StorehouseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StorehouseApplication.class,args);

		UserService userService = context.getBean(UserService.class);
		ProductService productService = context.getBean(ProductService.class);

		ProfileDao profileDao = context.getBean(ProfileDao.class);
		ShelfDao shelfDao = context.getBean(ShelfDao.class);
		PlaceDao placeDao = context.getBean(PlaceDao.class);
		CategoryDao categoryDao = context.getBean(CategoryDao.class);
		SubcategoryDao subcategoryDao = context.getBean(SubcategoryDao.class);
		VendorDao vendorDao = context.getBean(VendorDao.class);

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

		UserDto savedUser = userService.addUser(marco, profile, User.Type.EMPLOYEE);


		ProductDto product = new ProductDto();
		product.setName("wood table 1");
		product.setBrand("wood_company");
		product.setPrice(150.00);
		product.setStock(5);

		Place place = new Place();
		place.setShelf(shelfDao.save(new Shelf()));
		placeDao.save(place);

		Category category = new Category();
		category.setName("carpentry");
		category = categoryDao.save(category);

		Subcategory subcategory = new Subcategory();
		subcategory.setName("wood table");
		subcategory.setCategory(category);
		subcategory = subcategoryDao.save(subcategory);
		product.setSubcategoryName(subcategory.getName());

		Vendor vendor = new Vendor();
		vendor.setName("wood_company s.r.l.");
		vendor.setVATNumber("VATNUMBER123");
		vendor.setEmail("woodcompany@gmail.com");
		vendor.setPhone(33954841L);
		product.setVendorId(vendorDao.save(vendor).getId());

		ProductDto savedProd = productService.addProduct(product, place.getId());
	}
}


