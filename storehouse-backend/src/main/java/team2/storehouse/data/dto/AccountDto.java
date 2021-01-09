package team2.storehouse.data.dto;

import java.io.Serializable;

public class AccountDto implements Serializable {

    private UserDto userDto;

    private ProfileDto profileDto;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public ProfileDto getProfileDto() {
        return profileDto;
    }

    public void setProfileDto(ProfileDto profileDto) {
        this.profileDto = profileDto;
    }

}
