package uni.fmi.Solaris.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import uni.fmi.Solaris.models.User;

import java.time.LocalDateTime;
@Getter
@Setter
public class UserDTO extends BaseDTO<User>{
    private String name;
    private String password;
    private String email;
    private boolean isActive = true;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoggedAt;
    private String phone;
    private String address;
    public UserDTO(User user){
        super(user);
    }

    @Override
    public BaseDTO<User> convertToDTO(User entity) {
        setName(entity.getName());
        setId(entity.getId());
        setActive(entity.isActive());
        setEmail(entity.getEmail());
        setAddress(entity.getAddress());
        setCreatedAt(entity.getCreatedAt());
        setLastLoggedAt(entity.getLastLoggedAt());
        setPhone(entity.getPhone());
        return this;
    }
}
