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

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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

		InvoiceDao invoiceDao=context.getBean(InvoiceDao.class);
		Invoice invoice=new Invoice();


		invoice.setUserName("Sara Rinaldis");
		invoice.setUserVATNumber("09032310154");
		invoice.setUserAddress("Via pietro nenni 20");





		invoice.setStatusPayment(Invoice.Status.COMPLETED);
		invoice.setMethodPayment(Invoice.Method.PAYPAL);
		invoice.setBankName("Banca dal Fucino");
		invoice.setDate(LocalDate.now());
		invoice.setIban("IT19F031240321000000231647");

		invoice.setTotal(3200.00);
		invoice.setTaxes(128.00);
		invoice.setTotalTaxable(3328);
		invoice.setNetToPay(3328);
		invoiceDao.save(invoice);


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
 		marco.setType(User.Type.EMPLOYEE);

		ProfileDto profileMarco = new ProfileDto();
		profileMarco.setName("Marco");
		profileMarco.setSurname("Bellizzi");
		profileMarco.setAddress("Cosenza, via Adolfo Quintieri n. 44");

	//	profileMarco.setBirthdate(LocalDate.of(1996, 10, 24));
		profileMarco.setFiscalCode("bllmrc96r24a944n");
	//	profileMarco.setGender(Profile.Gender.MALE);
	//	profileMarco.setPhone(3284686896L);

		UserDto chiara = new UserDto();
		chiara.setUsername("chiaraPass");
		chiara.setEmail("chiara.passarelli97@gmail.com");
		chiara.setPassword("password123");
		chiara.setType(User.Type.EMPLOYEE);

		ProfileDto profileChiara = new ProfileDto();
		profileChiara.setName("Chiara");
		profileChiara.setSurname("Passarelli");
		profileChiara.setAddress("Vibo Valentia, via Don Giuseppe Puglisi 7");
		//profileMarco.setBirthdate(LocalDate.of(1996, 10, 24));
		profileChiara.setFiscalCode("psschr97p46g942z");

		UserDto maria = new UserDto();
		maria.setUsername("mariama");
		maria.setEmail("maria.macri23@gmail.com");
		maria.setPassword("ciao123");
		maria.setType(User.Type.EMPLOYEE);

		ProfileDto profileMaria = new ProfileDto();
		profileMaria.setName("maria");
		profileMaria.setSurname("macrì");
		profileMaria.setAddress("via pietro nenni 20");
		//profileMaria.setBirthdate(LocalDate.of(2014, 1, 1));
		profileMaria.setFiscalCode("mcrmra96b69f112j");
		//profileMaria.setGender(Profile.Gender.FEMALE);
		//profileMaria.setPhone(3288338284L);

		userService.addUser(marco, profileMarco);
		userService.addUser(maria, profileMaria);
		userService.addUser(chiara, profileChiara);
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

		Category potHolders=new Category();
		potHolders.setName("Pot holders");
		potHolders= categoryDao.save(potHolders);

		Category electronics=new Category();
		electronics.setName("Electronics");
		electronics= categoryDao.save(electronics);

		Category travelandLeisureProducts=new Category();
		travelandLeisureProducts.setName("Travel and leisure products");
		travelandLeisureProducts= categoryDao.save(travelandLeisureProducts);

		Category animals=new Category();
		animals.setName("Products for animals");
		animals= categoryDao.save(animals);

		Long place = 1L;

		Vendor ikea = new Vendor();
		ikea.setName("ikea s.r.l.");
		ikea.setVATNumber("IkEaVaTnUmBeR");
		ikea.setEmail("ikea@gmail.com");
		ikea.setPhone(3384792366L);
		ikea = vendorDao.save(ikea);

		Vendor amazon = new Vendor();
		amazon.setName("amazon s.r.l.");
		amazon.setVATNumber("AmAzOnVaTnUmBeR");
		amazon.setEmail("amazon@gmail.com");
		amazon.setPhone(3296851497L);
		amazon = vendorDao.save(amazon);

		// subcategories of winter

		Subcategory christmas = new Subcategory();
		christmas.setName("Christmas decorations");
		christmas.setCategory(winter);
		christmas = subcategoryDao.save(christmas);

		// products of christmas

		ProductDto treeBalls = new ProductDto();
		treeBalls.setName("tree balls");
		treeBalls.setBrand("ikea");
		treeBalls.setPrice(12.95);
		treeBalls.setColor("mixed color");
		treeBalls.setSize("7cm");
		treeBalls.setPhoto("https://www.ikea.com/ch/en/images/products/vinter-2020-decoration-bauble-set-of-32-mixed-colours__0888666_PE782120_S5.JPG?f=m");
		treeBalls.setStock(50);
		treeBalls.setPlace(placeDao.findById(place++).orElseThrow());
		treeBalls.setSubcategory(christmas);
		treeBalls.setVendor(ikea);
		productService.save(treeBalls);

		Subcategory paper = new Subcategory();
		paper.setName("Paper, gift bags and accessories");
		paper.setCategory(winter);
		paper = subcategoryDao.save(paper);

		// products of paper

		ProductDto winterPaper = new ProductDto();
		winterPaper.setName("winter paper");
		winterPaper.setBrand("ikea");
		winterPaper.setPrice(5.95);
		winterPaper.setColor("white");
		winterPaper.setSize("200x120cm");
		winterPaper.setPhoto("https://www.ikea.com/ch/en/images/products/vinter-2020-table-runner-medallion-pattern-white-red__0888787_PE782183_S5.JPG?f=xs");
		winterPaper.setStock(20);
		winterPaper.setPlace(placeDao.findById(place++).orElseThrow());
		winterPaper.setSubcategory(paper);
		winterPaper.setVendor(ikea);
		productService.save(winterPaper);

		Subcategory illuminations = new Subcategory();
		illuminations.setName("Christmas illuminations");
		illuminations.setCategory(winter);
		illuminations = subcategoryDao.save(illuminations);

		// products of illuminations

		ProductDto indoorLight = new ProductDto();
		indoorLight.setName("indoor light");
		indoorLight.setBrand("ikea");
		indoorLight.setPrice(29.95);
		indoorLight.setColor("yellow");
		indoorLight.setSize("300cm");
		indoorLight.setPhoto("https://www.ikea.com/ch/en/images/products/bloetsnoe-led-lighting-chain-with-24-lights-indoor-black__0884789_PE717319_S5.JPG?f=l");
		indoorLight.setStock(15);
		indoorLight.setPlace(placeDao.findById(place++).orElseThrow());
		indoorLight.setSubcategory(illuminations);
		indoorLight.setVendor(ikea);
		productService.save(indoorLight);

		// subcategory smart home

		Subcategory smartLighting = new Subcategory();
		smartLighting.setName("Smart Lighting");
		smartLighting.setCategory(smartHome);
		smartLighting = subcategoryDao.save(smartLighting);

		// products of smartLighting

		ProductDto smartLight = new ProductDto();
		smartLight.setName("smart light");
		smartLight.setBrand("ikea");
		smartLight.setPrice(19.95);
		smartLight.setColor("white");
		smartLight.setSize("50cm");
		smartLight.setPhoto("https://www.ikea.com/ch/en/images/products/lindshult-led-cabinet-lighting-nickel-plated__0881923_PE620620_S5.JPG?f=l");
		smartLight.setStock(10);
		smartLight.setPlace(placeDao.findById(place++).orElseThrow());
		smartLight.setSubcategory(smartLighting);
		smartLight.setVendor(ikea);
		productService.save(smartLight);

		Subcategory speakers = new Subcategory();
		speakers.setName("Wi-Fi speakers");
		speakers.setCategory(smartHome);
		speakers = subcategoryDao.save(speakers);

		// products of speakers

		ProductDto speaker = new ProductDto();
		speaker.setName("speaker");
		speaker.setBrand("ikea");
		speaker.setPrice(129.00);
		speaker.setColor("black");
		speaker.setSize("7x30x10cm");
		speaker.setPhoto("https://www.ikea.com/ch/en/images/products/symfonisk-wifi-bookshelf-speaker-black__0707117_PE726114_S5.JPG?f=m");
		speaker.setStock(30);
		speaker.setPlace(placeDao.findById(place++).orElseThrow());
		speaker.setSubcategory(speakers);
		speaker.setVendor(ikea);
		productService.save(speaker);

		Subcategory remoteControls = new Subcategory();
		remoteControls.setName("Remote controls for lights and wireless devices");
		remoteControls.setCategory(smartHome);
		remoteControls = subcategoryDao.save(remoteControls);

		// products of remote control

		ProductDto remoteBulbs = new ProductDto();
		remoteBulbs.setName("remote bulbs");
		remoteBulbs.setBrand("amazon");
		remoteBulbs.setPrice(14.89);
		remoteBulbs.setColor("many");
		remoteBulbs.setSize("25cm");
		remoteBulbs.setPhoto("https://www.therange.co.uk/_m4/2/3/1459497362_415.jpg");
		remoteBulbs.setStock(28);
		remoteBulbs.setPlace(placeDao.findById(place++).orElseThrow());
		remoteBulbs.setSubcategory(remoteControls);
		remoteBulbs.setVendor(amazon);
		productService.save(remoteBulbs);

		// subcategories of furniture

		Subcategory sofa = new Subcategory();
		sofa.setName("Sofas and sofa beds");
		sofa.setCategory(furniture);
		sofa = subcategoryDao.save(sofa);

		// products of sofa

		ProductDto sofaGrey = new ProductDto();
		sofaGrey.setName("sofa grey");
		sofaGrey.setBrand("ikea");
		sofaGrey.setPrice(399.00);
		sofaGrey.setColor("grey");
		sofaGrey.setSize("230x151x66cm");
		sofaGrey.setPhoto("https://www.ikea.com/ch/en/images/products/friheten-corner-sofa-bed-with-storage-skiftebo-dark-grey__0175610_PE328883_S5.JPG?f=m");
		sofaGrey.setStock(2);
		sofaGrey.setPlace(placeDao.findById(place++).orElseThrow());
		sofaGrey.setSubcategory(sofa);
		sofaGrey.setVendor(ikea);
		productService.save(sofaGrey);

		ProductDto sofaBlu = new ProductDto();
		sofaBlu.setName("sofa blu");
		sofaBlu.setBrand("ikea");
		sofaBlu.setPrice(399.00);
		sofaBlu.setColor("blue");
		sofaBlu.setSize("230x151x66cm");
		sofaBlu.setPhoto("https://www.ikea.com/ch/en/images/products/friheten-corner-sofa-bed-with-storage-skiftebo-blue__0690243_PE723167_S5.JPG?f=m");
		sofaBlu.setStock(2);
		sofaBlu.setPlace(placeDao.findById(place++).orElseThrow());
		sofaBlu.setSubcategory(sofa);
		sofaBlu.setVendor(ikea);
		productService.save(sofaBlu);

		Subcategory armchairs = new Subcategory();
		armchairs.setName("Armchairs, chaise-longue and footrest");
		armchairs.setCategory(furniture);
		armchairs = subcategoryDao.save(armchairs);

		// products of armchair

		ProductDto wingChair = new ProductDto();
		wingChair.setName("wing chair");
		wingChair.setBrand("ikea");
		wingChair.setPrice(299.00);
		wingChair.setColor("brown");
		wingChair.setSize("120x50x50cm");
		wingChair.setPhoto("https://www.ikea.com/ch/en/images/products/strandmon-wing-chair-jaerstad-brown__0534682_PE649222_S5.JPG?f=m");
		wingChair.setStock(10);
		wingChair.setPlace(placeDao.findById(place++).orElseThrow());
		wingChair.setSubcategory(armchairs);
		wingChair.setVendor(ikea);
		productService.save(wingChair);

		Subcategory tablesDesks = new Subcategory();
		tablesDesks.setName("Tables and desks");
		tablesDesks.setCategory(furniture);
		tablesDesks = subcategoryDao.save(tablesDesks);

		// products of table desk

		ProductDto table = new ProductDto();
		table.setName("table");
		table.setBrand("ikea");
		table.setPrice(149.95);
		table.setColor("brown");
		table.setSize("140x65cm");
		table.setPhoto("https://www.ikea.com/ch/en/images/products/hilver-table-bamboo__0736766_PE740721_S5.JPG?f=m");
		table.setStock(3);
		table.setPlace(placeDao.findById(place++).orElseThrow());
		table.setSubcategory(tablesDesks);
		table.setVendor(ikea);
		productService.save(table);

		// subcategory of beds and mattresses

		Subcategory bed = new Subcategory();
		bed.setName("Beds");
		bed.setCategory(beds);
		bed = subcategoryDao.save(bed);

		// products of beds

		ProductDto divanBed = new ProductDto();
		divanBed.setName("divan bed");
		divanBed.setBrand("ikea");
		divanBed.setPrice(1199.00);
		divanBed.setColor("white");
		divanBed.setSize("200x180cm");
		divanBed.setPhoto("https://www.ikea.com/ch/en/images/products/dunvik-divan-bed-hoevag-firm-tussoey-dark-grey__0392278_PE574689_S5.JPG?f=xxs");
		divanBed.setStock(3);
		divanBed.setPlace(placeDao.findById(place++).orElseThrow());
		divanBed.setSubcategory(bed);
		divanBed.setVendor(ikea);
		productService.save(divanBed);

		Subcategory wardrobes = new Subcategory();
		wardrobes.setName("Wardrobes");
		wardrobes.setCategory(home);
		wardrobes = subcategoryDao.save(wardrobes);

		ProductDto wardrobe = new ProductDto();
		wardrobe.setName("wardrobe 3 doors");
		wardrobe.setBrand("ikea");
		wardrobe.setPrice(781.00);
		wardrobe.setColor("dark green");
		wardrobe.setSize("200x180x80cm");
		wardrobe.setPhoto("https://www.ikea.com/ch/en/images/products/platsa-wardrobe-with-9-doors-3-drawers-white-klubbukt-grey-green__0888384_PE783144_S5.JPG?f=sg");
		wardrobe.setStock(6);
		wardrobe.setPlace(placeDao.findById(place++).orElseThrow());
		wardrobe.setSubcategory(wardrobes);
		wardrobe.setVendor(ikea);
		productService.save(wardrobe);

		Subcategory kitchen = new Subcategory();
		kitchen.setName("Kitchens");
		kitchen.setCategory(kitchens);
		kitchen = subcategoryDao.save(kitchen);

		ProductDto kitchenComplete = new ProductDto();
		kitchenComplete.setName("kitchen complete");
		kitchenComplete.setBrand("ikea");
		kitchenComplete.setPrice(343.95);
		kitchenComplete.setColor("white");
		kitchenComplete.setSize("300x90x70cm");
		kitchenComplete.setPhoto("https://www.ikea.com/ch/en/images/products/knoxhult-kitchen-white__0458048_PE605387_S5.JPG?f=xxs");
		kitchenComplete.setStock(5);
		kitchenComplete.setPlace(placeDao.findById(place++).orElseThrow());
		kitchenComplete.setSubcategory(kitchen);
		kitchenComplete.setVendor(ikea);
		productService.save(kitchenComplete);

		Subcategory baby = new Subcategory();
		baby.setName("Baby");
		baby.setCategory(babies);
		baby = subcategoryDao.save(baby);

		ProductDto cot = new ProductDto();
		cot.setName("cot");
		cot.setBrand("ikea");
		cot.setPrice(84.95);
		cot.setColor("white");
		cot.setSize("120x70x60cm");
		cot.setPhoto("https://www.ikea.com/ch/en/images/products/gulliver-cot-white__0637927_PE698612_S5.JPG?f=xxs");
		cot.setStock(15);
		cot.setPlace(placeDao.findById(place++).orElseThrow());
		cot.setSubcategory(baby);
		cot.setVendor(ikea);
		productService.save(cot);

		Subcategory bathTextiles = new Subcategory();
		bathTextiles.setName("Bath Textiles");
		bathTextiles.setCategory(textiles);
		bathTextiles = subcategoryDao.save(bathTextiles);

		ProductDto towel = new ProductDto();
		towel.setName("towel");
		towel.setBrand("ikea");
		towel.setPrice(6.95);
		towel.setColor("dark grey");
		towel.setSize("70cm");
		towel.setPhoto("https://www.ikea.com/ch/en/images/products/vagsjoen-bath-towel-dark-grey__0604997_PE681580_S5.JPG?f=xxs");
		towel.setStock(60);
		towel.setPlace(placeDao.findById(place++).orElseThrow());
		towel.setSubcategory(bathTextiles);
		towel.setVendor(ikea);
		productService.save(towel);

		Subcategory mirrors = new Subcategory();
		mirrors.setName("Mirrors");
		mirrors.setCategory(decoration);
		mirrors = subcategoryDao.save(mirrors);

		ProductDto wallMirror = new ProductDto();
		wallMirror.setName("wall mirror");
		wallMirror.setBrand("ikea");
		wallMirror.setPrice(59.95);
		wallMirror.setColor("white");
		wallMirror.setSize("100x40cm");
		wallMirror.setPhoto("https://www.ikea.com/ch/en/images/products/toftbyn-mirror-white__0921417_PE787810_S5.JPG?f=xxs");
		wallMirror.setStock(17);
		wallMirror.setPlace(placeDao.findById(place++).orElseThrow());
		wallMirror.setSubcategory(mirrors);
		wallMirror.setVendor(ikea);
		productService.save(wallMirror);

		Subcategory lamps = new Subcategory();
		lamps.setName("Lamps");
		lamps.setCategory(lighting);
		lamps = subcategoryDao.save(lamps);

		ProductDto lamp = new ProductDto();
		lamp.setName("work lamp");
		lamp.setBrand("ikea");
		lamp.setPrice(12.95);
		lamp.setColor("black");
		lamp.setSize("40cm");
		lamp.setPhoto("https://www.ikea.com/ch/en/images/products/tertial-work-lamp-dark-grey__0879117_PE622662_S5.JPG?f=xxs");
		lamp.setStock(28);
		lamp.setPlace(placeDao.findById(place++).orElseThrow());
		lamp.setSubcategory(lamps);
		lamp.setVendor(ikea);
		productService.save(lamp);

		Subcategory knives = new Subcategory();
		knives.setName("Knives");
		knives.setCategory(tables);
		knives = subcategoryDao.save(knives);

		ProductDto knivesSet = new ProductDto();
		knivesSet.setName("knives set");
		knivesSet.setBrand("ikea");
		knivesSet.setPrice(34.95);
		knivesSet.setColor("silver");
		knivesSet.setSize("mixed");
		knivesSet.setPhoto("https://www.ikea.com/ch/en/images/products/ikea-365-3-piece-knife-set__0448596_PE598262_S5.JPG?f=xxs");
		knivesSet.setStock(55);
		knivesSet.setPlace(placeDao.findById(place++).orElseThrow());
		knivesSet.setSubcategory(knives);
		knivesSet.setVendor(ikea);

		Subcategory showers = new Subcategory();
		showers.setName("Showers");
		showers.setCategory(bath);
		showers = subcategoryDao.save(showers);

		ProductDto shower = new ProductDto();
		shower.setName("shower set");
		shower.setBrand("ikea");
		shower.setPrice(199.00);
		shower.setColor("silver");
		shower.setSize("80cm");
		shower.setPhoto("https://www.ikea.com/ch/en/images/products/brogrund-shower-set-with-thermostatic-mixer-chrome-plated__0864139_PE668870_S5.JPG?f=sg");
		shower.setStock(14);
		shower.setPlace(placeDao.findById(place++).orElseThrow());
		shower.setSubcategory(showers);
		shower.setVendor(ikea);
		productService.save(shower);

		Subcategory rugs = new Subcategory();
		rugs.setName("Rugs");
		rugs.setCategory(carpetsAndDoormats);
		subcategoryDao.save(rugs);

		ProductDto roundRug = new ProductDto();
		roundRug.setName("round rug");
		roundRug.setBrand("ikea");
		roundRug.setPrice(49.95);
		roundRug.setColor("dark grey");
		roundRug.setSize("80cm");
		roundRug.setPhoto("https://www.ikea.com/ch/en/images/products/stoense-rug-low-pile-medium-grey__0892718_PE690627_S5.JPG?f=xxs");
		roundRug.setStock(34);
		roundRug.setPlace(placeDao.findById(place++).orElseThrow());
		roundRug.setSubcategory(rugs);
		roundRug.setVendor(ikea);
		productService.save(roundRug);

		Subcategory plants = new Subcategory();
		plants.setName("Plants");
		plants.setCategory(gardenFurniture);
		plants = subcategoryDao.save(plants);

		ProductDto aloeVera = new ProductDto();
		aloeVera.setName("Aloe Vera");
		aloeVera.setBrand("ikea");
		aloeVera.setPrice(4.95);
		aloeVera.setColor("green");
		aloeVera.setSize("small");
		aloeVera.setPhoto("https://www.ikea.com/ch/en/images/products/aloe-vera-potted-plant-aloe__0653978_PE708207_S5.JPG?f=xxs");
		aloeVera.setStock(37);
		aloeVera.setPlace(placeDao.findById(place++).orElseThrow());
		aloeVera.setSubcategory(plants);
		aloeVera.setVendor(ikea);
		productService.save(aloeVera);

		Subcategory indoorPots = new Subcategory();
		indoorPots.setName("Indoor pots");
		indoorPots.setCategory(potHolders);
		indoorPots = subcategoryDao.save(indoorPots);

		ProductDto pot = new ProductDto();
		pot.setName("Pot");
		pot.setBrand("ikea");
		pot.setPrice(19.95);
		pot.setColor("white");
		pot.setSize("60cm");
		pot.setPhoto("https://www.ikea.com/ch/en/images/products/nypon-plant-pot-in-outdoor-grey__0899651_PE700355_S5.JPG?f=xxs");
		pot.setStock(41);
		pot.setSubcategory(indoorPots);
		pot.setPlace(placeDao.findById(place++).orElseThrow());
		pot.setVendor(ikea);
		productService.save(pot);

		Subcategory fridges = new Subcategory();
		fridges.setName("Fridges");
		fridges.setCategory(electronics);
		fridges = subcategoryDao.save(fridges);

		ProductDto fridge = new ProductDto();
		fridge.setName("Fridge");
		fridge.setBrand("ikea");
		fridge.setColor("silver");
		fridge.setSize("190x40x45cm");
		fridge.setPrice(999.99);
		fridge.setPhoto("https://www.ikea.com/ch/en/images/products/kylslagen-fridge-freezer-stainless-steel__0755789_PE748598_S5.JPG?f=xxs");
		fridge.setStock(6);
		fridge.setSubcategory(fridges);
		fridge.setPlace(placeDao.findById(place++).orElseThrow());
		fridge.setVendor(ikea);
		productService.save(fridge);

		Subcategory bags = new Subcategory();
		bags.setName("Bags");
		bags.setCategory(travelandLeisureProducts);
		bags = subcategoryDao.save(bags);

		ProductDto backpack = new ProductDto();
		backpack.setName("Backpack");
		backpack.setBrand("ikea");
		backpack.setColor("dark grey");
		backpack.setSize("60x35xm");
		backpack.setPrice(39.95);
		backpack.setPhoto("https://www.ikea.com/ch/en/images/products/vaerldens-backpack-dark-grey__0815697_PE773015_S5.JPG?f=xxs");
		backpack.setStock(76);
		backpack.setSubcategory(bags);
		backpack.setPlace(placeDao.findById(place++).orElseThrow());
		backpack.setVendor(ikea);
		productService.save(backpack);

		Subcategory cats = new Subcategory();
		cats.setName("Cats");
		cats.setCategory(animals);
		cats = subcategoryDao.save(cats);

		ProductDto catHouse = new ProductDto();
		catHouse.setName("cat house");
		catHouse.setBrand("ikea");
		catHouse.setColor("fantasy");
		catHouse.setSize("60x60x60cm");
		catHouse.setPrice(19.90);
		catHouse.setPhoto("https://www.ikea.com/ch/en/images/products/lurvig-cat-house-with-cushion-white-light-grey__0795262_PE765912_S5.JPG?f=xxs");
		catHouse.setStock(38);
		catHouse.setSubcategory(cats);
		catHouse.setPlace(placeDao.findById(place++).orElseThrow());
		catHouse.setVendor(ikea);
		productService.save(catHouse);


		List<ProductDto> winter1 = productService.findProductBySubcategory((long)1);

		System.err.println("Storehouse initialized");
		for (ProductDto p:winter1
			 ) {
			System.out.println(p);
		}


	}
}


