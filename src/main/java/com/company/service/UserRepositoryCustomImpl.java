package com.company.service;

import com.company.dto.UserDTO;
import com.company.entity.Address;
import com.company.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em;


    @Override
    public UserDTO save(UserDTO userDTO) {
        Assert.isNull(userDTO.getName() , " ad bosh olmaz");

        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());

        em.persist(user);

        List<Address> list = new ArrayList<Address>();

        List<String> addressList = userDTO.getAddressList();
        for(String item : addressList){
             Address address = new Address();
             address.setAddress(item);

             list.add(address);
        }
        em.persist(list);

        return userDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<UserDTO> getAll() {
        Query q = em.createQuery("select u from User u ");
        List<User> list = q.getResultList();
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();

        for (User user : list){
           UserDTO userDTO = new UserDTO();
           userDTO.setId(user.getId());
           userDTO.setName(user.getName());
           userDTO.setSurname(user.getSurname());
           userDTO.setAddressList(null);

           userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public Page<UserDTO> getAll(Pageable pageable) {
        return null;
    }
}
