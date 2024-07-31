package service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.dto.UserDTO;

import service.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Override
	public List<UserDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
