package team2.storehouse;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import team2.storehouse.data.dao.ProfileDao;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.Profile;
import team2.storehouse.data.entities.User;
import team2.storehouse.data.service.UserService;

import java.time.LocalDate;

@SpringBootApplication
public class StorehouseApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(StorehouseApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(StorehouseApplication.class,args);
		UserService userService = context.getBean(UserService.class);
		ProfileDao profileDao = context.getBean(ProfileDao.class);

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

