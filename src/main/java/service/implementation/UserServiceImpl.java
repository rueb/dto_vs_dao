package service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.interfaces.IUserDAO;
import com.demo.dto.UserDTO;
import com.demo.entity.User;

import service.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDAO iuserDao;

	@Override
	public List<UserDTO> findAll() {
		
		ModelMapper modelMapper = new ModelMapper();
		
		return this.iuserDao.findAll()
				.stream()
				.map(entity -> modelMapper.map(entity, UserDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public UserDTO findById(Integer id) {
		Optional<User> user = this.iuserDao.findById(id);
		
		if(user.isPresent()) {
			ModelMapper modelMapper = new ModelMapper();
			User currentUser = user.get();
			return modelMapper.map(currentUser,UserDTO.class);
		}else {
			return new UserDTO();
		}
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		try {
			ModelMapper modelMapper = new ModelMapper();
			User user = modelMapper.map(userDTO, User.class);
			this.iuserDao.saveUser(user);
			return userDTO;
		}catch(Exception ex){
			throw new UnsupportedOperationException("Error al guardar el usuario");
		}
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer id) {
		Optional<User>user = this.iuserDao.findById(id);
		
		if(user.isPresent()) {
			User currentUser = user.get();
			currentUser.setName(userDTO.getName());
			currentUser.setLastName(userDTO.getLastName());
			currentUser.setEmail(userDTO.getEmail());
			currentUser.setAge(userDTO.getAge());
			
			this.iuserDao.updateUser(currentUser);
			
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(currentUser, UserDTO.class);
		}else {
			throw new UnsupportedOperationException("Error al actualizar el usuario");
		}
	}

	@Override
	public String deleteUser(Integer id) {
		
		Optional<User>user = this.iuserDao.findById(id);
		
		if(user.isPresent()) {
			User  currentUser = user.get();
			this.iuserDao.deleteUser(currentUser);
			return "User with ID "+ id +" delete success";
		}else {
			return "El usuario con ID "+ id + " no existe";
		}
	}

}
