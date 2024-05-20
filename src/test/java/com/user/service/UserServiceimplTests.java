package com.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.user.exception.NoData;
import com.user.exception.UserDoesntExists;
import com.user.exception.UserExists;
import com.user.model.User;
import com.user.repo.userRepo;
import com.user.utlity.ServiceUtlity;

public class UserServiceimplTest {

    @InjectMocks
    UserServiceimpl userService;

    @Mock
    userRepo userRepo;

    @Mock
    ServiceUtlity serviceutlity;

    @Mock
    HttpServletRequest http;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        when(userRepo.findAll()).thenReturn(Arrays.asList(new User()));
        List<User> users = userService.getAllUsers();
        assertEquals(1, users.size());
    }

    @Test
    public void testGetAllUsers_NoData() {
        when(userRepo.findAll()).thenReturn(Arrays.asList());
        assertThrows(NoData.class, () -> userService.getAllUsers());
    }

    @Test
    public void testGetByUsername() {
        when(userRepo.findByUserName("username")).thenReturn(Optional.of(new User()));
        User user = userService.getByUsername("username", "name", http, "lastname");
        assertEquals(new User(), user);
    }

    @Test
    public void testGetByUsername_UserDoesntExists() {
        when(userRepo.findByUserName("username")).thenReturn(Optional.empty());
        assertThrows(UserDoesntExists.class, () -> userService.getByUsername("username", "name", http, "lastname"));
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUserName("username");
        when(userRepo.existsByUserName("username")).thenReturn(false);
        when(userRepo.save(user)).thenReturn(user);
        User savedUser = userService.saveUser(user);
        assertEquals(user, savedUser);
    }

    @Test
    public void testSaveUser_UserExists() {
        User user = new User();
        user.setUserName("username");
        when(userRepo.existsByUserName("username")).thenReturn(true);
        assertThrows(UserExists.class, () -> userService.saveUser(user));
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUserName("username");
        when(userRepo.existsByUserName("username")).thenReturn(true);
        when(userRepo.getByusername("username")).thenReturn(user);
        when(userRepo.save(user)).thenReturn(user);
        User updatedUser = userService.updateUser(user);
        assertEquals(user, updatedUser);
    }

    @Test
    public void testUpdateUser_UserDoesntExists() {
        User user = new User();
        user.setUserName("username");
        when(userRepo.existsByUserName("username")).thenReturn(false);
        assertThrows(UserDoesntExists.class, () -> userService.updateUser(user));
    }

    @Test
    public void testDeleteByUserName() {
        when(userRepo.existsByUserName("username")).thenReturn(true);
        when(userRepo.deleteByUserName("username")).thenReturn(1L);
        Long deleted = userService.deleteByUserName("username");
        assertEquals(1L, deleted);
    }

    @Test
    public void testDeleteByUserName_UserDoesntExists() {
        when(userRepo.existsByUserName("username")).thenReturn(false);
        assertThrows(UserDoesntExists.class, () -> userService.deleteByUserName("username"));
    }
}