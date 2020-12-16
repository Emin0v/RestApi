package com.company.service;

import com.company.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryCustom {

    UserDTO save(UserDTO userDTO);

    boolean delete(Integer id);

    List<UserDTO> getAll();

    Page<UserDTO> getAll(Pageable pageable);
}
