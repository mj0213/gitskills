package org.springboot.jpa.serviceImpl;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springboot.jpa.entity.User;
import org.springboot.jpa.service.UserRepository;
import org.springboot.jpa.service.UsreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UsreService{

	@Autowired UserRepository userRepository;
	
	@Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public User findByUserNameOrAge(String userName, Integer age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByAge(Integer age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteByAge(Integer age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByUserNameLike(String userName) {
		return userRepository.findByUserNameLike(userName);
	}


	@Override
	public Page<User> findByAge(Integer age, Pageable pageable) {
		return userRepository.findByAge(age, pageable);
	}

	@Override
	public int delByIdAndName(Long id,String userName) {
		return userRepository.delByIdAndName(id, userName);
	}

	@Override
	public List getUserClass(Long userId) {
		return userRepository.getUserClass(userId);
	}

    
    

}
