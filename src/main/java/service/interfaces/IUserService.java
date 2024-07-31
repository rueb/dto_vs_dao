package service.interfaces;

import java.util.List;

import com.demo.dto.UserDTO;

public interface IUserService {

	public List<UserDTO>findAll();
	UserDTO findById(Integer id);
	UserDTO createUser(UserDTO userDTO);
	UserDTO updateUser(UserDTO userDTO);
	UserDTO deleteUser(Integer id);
}
