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
		//categories
		Category winter = new Category();
		winter.setName("Winter");
		winter = categoryDao.save(winter);

		Category smartHome = new Category();
		smartHome.setName("Smart Home");
		smartHome = categoryDao.save(smartHome);

		Category furniture = new Category();
		furniture.setName("Furniture");
		furniture = categoryDao.save(furniture);

		Category beds = new Category();
		beds.setName("Beds and mattresses");
		beds = categoryDao.save(beds);

		Category home = new Category();
		home.setName("Home organization products");
		home = categoryDao.save(home);

		Category kitchens=new Category();
		kitchens.setName("Kitchens and appliances");
		kitchens= categoryDao.save(kitchens);

		Category babies=new Category();
		babies.setName("Babies and children");
		babies= categoryDao.save(babies);

		Category textiles=new Category();
		textiles.setName("Textiles");
		textiles= categoryDao.save(textiles);

		Category decoration = new Category();
		decoration.setName("Decoration");
		decoration = categoryDao.save(decoration);

		Category lighting = new Category();
		lighting.setName("Lighting");
		lighting = categoryDao.save(lighting);

		Category tables = new Category();
		tables.setName("Products for the table");
		tables = categoryDao.save(tables);

		Category bath = new Category();
		bath.setName("Bath products");
		bath = categoryDao.save(bath);

		Category carpetsAndDoormats=new Category();
		carpetsAndDoormats.setName("Carpets and doormats");
		carpetsAndDoormats= categoryDao.save(carpetsAndDoormats);

		Category gardenFurniture= new Category();
		gardenFurniture.setName("Garden Furniture");
		gardenFurniture= categoryDao.save(gardenFurniture);

		Category potHoldersAndPlants=new Category();
		potHoldersAndPlants.setName("Pot holders and plants");
		potHoldersAndPlants= categoryDao.save(potHoldersAndPlants);


		Category electronics=new Category();
		electronics.setName("Electronics");
		electronics= categoryDao.save(electronics);

		Category travelandLeisureProducts=new Category();
		travelandLeisureProducts.setName("Travel and leisure products");
		travelandLeisureProducts= categoryDao.save(travelandLeisureProducts);

		Category animals=new Category();
		animals.setName("Products for animals");
		animals= categoryDao.save(animals);



		//subcategories of  winter
		Subcategory christmas = new Subcategory();
		christmas.setName("Christmas decorations");
		christmas.setCategory(winter);
		christmas = subcategoryDao.save(christmas);


		Subcategory paper = new Subcategory();
		paper.setName("Paper, gift bags and accessories");
		paper.setCategory(winter);
		paper = subcategoryDao.save(paper);

		Subcategory illuminations = new Subcategory();
		illuminations.setName("Christmas illuminations");
		illuminations.setCategory(winter);
		illuminations = subcategoryDao.save(illuminations);

		//subcategory smart home

		Subcategory smartLighting = new Subcategory();
		smartLighting.setName("Smart Lighting");
		smartLighting.setCategory(smartHome);
		smartLighting = subcategoryDao.save(smartLighting);


		Subcategory speakers = new Subcategory();
		speakers.setName("Wi-Fi speakers");
		speakers.setCategory(smartHome);
		speakers = subcategoryDao.save(speakers);

		Subcategory remoteControls = new Subcategory();
		remoteControls.setName("Remote controls for lights and wireless devices");
		remoteControls.setCategory(smartHome);
		remoteControls = subcategoryDao.save(remoteControls);


		//subcategories of furniture
		Subcategory sofa = new Subcategory();
		sofa.setName("Sofas and sofa beds");
		sofa.setCategory(furniture);
		sofa = subcategoryDao.save(sofa);


		Subcategory armchairs = new Subcategory();
		armchairs.setName("Armchairs, chaise-longue and footrest");
		armchairs.setCategory(furniture);
		armchairs = subcategoryDao.save(armchairs);

		Subcategory tablesDesks = new Subcategory();
		tablesDesks.setName("Tables and desks");
		tablesDesks.setCategory(furniture);
		tablesDesks = subcategoryDao.save(tablesDesks);

		//













		Subcategory woodTable = new Subcategory();
		woodTable.setName("wood table");
		woodTable.setCategory(furniture);
		woodTable = subcategoryDao.save(woodTable);
		System.out.println(woodTable);

		Subcategory woodChair = new Subcategory();
		woodChair.setName("wood chair");
		woodChair.setCategory(furniture);
		woodChair = subcategoryDao.save(woodChair);

		Subcategory woodWardrobe = new Subcategory();
		woodWardrobe.setName("wood wardrobe");
		woodWardrobe.setCategory(furniture);
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
		table.setPlace(placeDao.findById(1L).orElseThrow());
		table.setSubcategory(subcategoryDao.findByName("wood table").orElseThrow(() -> new RuntimeException("subcategory not found")));
		table.setVendor(vendorDao.findById(Long.valueOf(1)).orElseThrow(() -> new RuntimeException("vendor not found")));

		ProductDto chair = new ProductDto();
		chair.setName("wood chair medium");
		chair.setBrand("ikea");
		chair.setPrice(20.00);
		chair.setColor("black");
		chair.setSize("50x60cm");
		chair.setStock(10);
		chair.setPlace(placeDao.findById(2L).orElseThrow());
		chair.setSubcategory(subcategoryDao.findByName("wood chair").orElseThrow(() -> new RuntimeException("subcategory not found")));
		chair.setVendor(vendorDao.findById(Long.valueOf(1)).orElseThrow(() -> new RuntimeException("vendor not found")));

		ProductDto wardrobe = new ProductDto();
		wardrobe.setName("wardrobe");
		wardrobe.setBrand("ikea");
		wardrobe.setPrice(200.00);
		wardrobe.setColor("white");
		wardrobe.setSize("2000x1000cm");
		wardrobe.setStock(3);
		wardrobe.setPlace(placeDao.findById(3L).orElseThrow());
		wardrobe.setSubcategory(subcategoryDao.findByName("wood wardrobe").orElseThrow(() -> new RuntimeException("subcategory not found")));
		wardrobe.setVendor(vendorDao.findById(Long.valueOf(1)).orElseThrow(() -> new RuntimeException("vendor not found")));


		productService.addProduct(table);
		productService.addProduct(chair);
		productService.addProduct(wardrobe);
		Long id= (long )1;
		SubcategoryDao.findByCategory( id);
		System.err.println("Storehouse initialized");

	}
}


