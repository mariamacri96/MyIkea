package team2.storehouse;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.User;
import team2.storehouse.data.service.UserService;

@SpringBootApplication
public class StorehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorehouseApplication.class, args);
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

