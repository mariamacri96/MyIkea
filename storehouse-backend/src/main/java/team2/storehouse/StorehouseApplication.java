package team2.storehouse;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import team2.storehouse.data.dao.*;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.*;
import team2.storehouse.data.service.ProductService;
import team2.storehouse.data.service.UserService;

import java.time.LocalDate;

@SpringBootApplication
public class StorehouseApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(StorehouseApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(StorehouseApplication.class,args);
		UserService userService = context.getBean(UserService.class);
		ProductService productService = context.getBean(ProductService.class);

		ProfileDao profileDao = context.getBean(ProfileDao.class);
		ShelfDao shelfDao = context.getBean(ShelfDao.class);
		PlaceDao placeDao = context.getBean(PlaceDao.class);
		CategoryDao categoryDao = context.getBean(CategoryDao.class);
		SubCategoryDao subcategoryDao = context.getBean(SubCategoryDao.class);
		VendorDao vendorDao = context.getBean(VendorDao.class);

		UserDto marco = new UserDto();
		marco.setUsername("marcoBellizzi");
		marco.setEmail("marco@gmail.com");
		marco.setPassword("password123");

		Profile profile = new Profile();
		profile.setName("Marco");
		profile.setSurname("Bellizzi");
		profile.setAddress("Cosenza, via ... ");
		profile.setBirthdate(LocalDate.of(1996, 10, 24));
		profile.setFiscalCode("codiceFiscale");
		profile.setGender(Profile.Gender.MALE);
		profile.setPhone(3284686896L);
		profileDao.save(profile);

		UserDto saved = userService.addUser(marco, profile, User.Type.EMPLOYEE);

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
		product.setSubcategory(subcategoryDao.save(subcategory));

		Vendor vendor = new Vendor();
		vendor.setName("wood_company s.r.l.");
		vendor.setVATNumber("VATNUMBER123");
		vendor.setEmail("woodcompany@gmail.com");
		vendor.setPhone(33954841L);
		product.setVendor(vendorDao.save(vendor));

		ProductDto savedProd = productService.addProduct(product, place, 5);
	}
}

/*
	ConfigurableApplicationContext context= SpringApplication.run(StorehouseApplication.class,args);
	UserService userService= context.getBean(UserService.class);
	userService.addUser(createUser(1));
	userService.addUser(createUser(2));

}

	public static UserDto createUser(int i){
		ModelMapper modelMapper= new ModelMapper();
		User user =new User();

		user.setEmail("maria@"+1);
		user.setPassword("capa"+ i);
		return modelMapper.map(user, UserDto.class);
	}
}
*/

