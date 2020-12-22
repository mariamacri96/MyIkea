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

		// Service
		UserService userService = context.getBean(UserService.class);
		ProductService productService = context.getBean(ProductService.class);

		// Dao
		ShelfDao shelfDao = context.getBean(ShelfDao.class);
		PlaceDao placeDao = context.getBean(PlaceDao.class);
		CategoryDao categoryDao = context.getBean(CategoryDao.class);
		SubcategoryDao subcategoryDao = context.getBean(SubcategoryDao.class);
		VendorDao vendorDao = context.getBean(VendorDao.class);

		for(int i=0; i<10; i++) {
			Shelf shelf = shelfDao.save(new Shelf());
			for(int j=0; j<10; j++) {
				Place place = new Place();
				place.setShelf(shelf);
				placeDao.save(place);
			}
		}

		UserDto marco = new UserDto();
		marco.setUsername("marcoBellizzi");
		marco.setEmail("marcobellizzi96@gmail.com");
		marco.setPassword("password123");

		ProfileDto profileMarco = new ProfileDto();
		profileMarco.setName("Marco");
		profileMarco.setSurname("Bellizzi");
		profileMarco.setAddress("Cosenza, via Adolfo Quintieri n. 44");
		profileMarco.setBirthdate(LocalDate.of(1996, 10, 24));
		profileMarco.setFiscalCode("bllmrc96r24a944n");
		profileMarco.setGender(Profile.Gender.MALE);
		profileMarco.setPhone(3284686896L);

		UserDto maria = new UserDto();
		maria.setUsername("mariama");
		maria.setEmail("maria.macri23@gmail.com");
		maria.setPassword("ciao123");

		ProfileDto profileMaria = new ProfileDto();
		profileMaria.setName("maria");
		profileMaria.setSurname("macrì");
		profileMaria.setAddress("via pietro nenni 20");
		profileMaria.setBirthdate(LocalDate.of(2014, 1, 1));
		profileMaria.setFiscalCode("mcrmra96b69f112j");
		profileMaria.setGender(Profile.Gender.FEMALE);
		profileMaria.setPhone(3288338284L);

		userService.addUser(marco, profileMarco, User.Type.EMPLOYEE);
		userService.addUser(maria, profileMaria, User.Type.EMPLOYEE);

		Category carpentry = new Category();
		carpentry.setName("carpentry");
		carpentry = categoryDao.save(carpentry);

		Subcategory woodTable = new Subcategory();
		woodTable.setName("wood table");
		woodTable.setCategory(carpentry);
		woodTable = subcategoryDao.save(woodTable);

		Subcategory woodChair = new Subcategory();
		woodChair.setName("wood chair");
		woodChair.setCategory(carpentry);
		woodChair = subcategoryDao.save(woodChair);

		Subcategory woodWardrobe = new Subcategory();
		woodWardrobe.setName("wood wardrobe");
		woodWardrobe.setCategory(carpentry);
		woodWardrobe = subcategoryDao.save(woodWardrobe);

		Vendor ikea = new Vendor();
		ikea.setName("ikea s.r.l.");
		ikea.setVATNumber("VATNUMBER123");
		ikea.setEmail("ikea@gmail.com");
		ikea.setPhone(3384792366L);
		ikea = vendorDao.save(ikea);

		ProductDto table = new ProductDto();
		table.setName("wood table medium");
		table.setBrand("ikea");
		table.setPrice(150.00);
		table.setColor("black");
		table.setSize("100x120cm");
		table.setStock(5);
		table.setSubcategory(subcategoryDao.findByName("wood table").orElseThrow(() -> new RuntimeException("subcategory not found")));
		table.setVendor(vendorDao.findById(Long.valueOf(1)).orElseThrow(() -> new RuntimeException("vendor not found")));

		ProductDto chair = new ProductDto();
		chair.setName("wood chair medium");
		chair.setBrand("ikea");
		chair.setPrice(20.00);
		chair.setColor("black");
		chair.setSize("50x60cm");
		chair.setStock(10);
		chair.setSubcategory(subcategoryDao.findByName("wood chair").orElseThrow(() -> new RuntimeException("subcategory not found")));
		chair.setVendor(vendorDao.findById(Long.valueOf(1)).orElseThrow(() -> new RuntimeException("vendor not found")));

		ProductDto wardrobe = new ProductDto();
		wardrobe.setName("wardrobe");
		wardrobe.setBrand("ikea");
		wardrobe.setPrice(200.00);
		wardrobe.setColor("white");
		wardrobe.setSize("2000x1000cm");
		wardrobe.setStock(3);
		wardrobe.setSubcategory(subcategoryDao.findByName("wood wardrobe").orElseThrow(() -> new RuntimeException("subcategory not found")));
		wardrobe.setVendor(vendorDao.findById(Long.valueOf(1)).orElseThrow(() -> new RuntimeException("vendor not found")));


		productService.addProduct(table, Long.valueOf(1));
		productService.addProduct(chair, Long.valueOf(2));
		productService.addProduct(wardrobe, Long.valueOf(3));

		System.err.println("Storehouse initialized");

	}
}


