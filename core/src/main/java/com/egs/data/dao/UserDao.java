package com.egs.data.dao;

import com.egs.common.data.model.User;
import com.egs.common.exception.DatabaseException;
import com.egs.common.exception.EntityNotFoundException;

import java.util.List;

public interface UserDao {

    void add(User user) throws DatabaseException;

    User getByID(long id) throws EntityNotFoundException, DatabaseException;

    boolean isEmailExist(String email) throws DatabaseException;

    boolean isEmailExist(String email, Long excludedUserID) throws DatabaseException;

    User getByEmail(String email) throws DatabaseException;

    List<User> getAll() throws DatabaseException;

    List<User> getAll(List<Long> excludedUserIDs) throws DatabaseException;

    void edit(User user) throws EntityNotFoundException, DatabaseException;

    void removeByID(long id) throws EntityNotFoundException, DatabaseException;
}
