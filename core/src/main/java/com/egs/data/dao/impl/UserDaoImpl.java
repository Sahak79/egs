package com.egs.data.dao.impl;

import com.egs.common.data.model.User;
import com.egs.common.exception.DatabaseException;
import com.egs.common.exception.EntityNotFoundException;
import com.egs.data.dao.UserDao;
import com.egs.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    private UserRepository repository;

    @Autowired
    public UserDaoImpl(UserRepository repository) {
        this.repository = repository;
    }

    public void add(User user) throws DatabaseException {
        try {
            repository.save(user);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public User getByID(long id) throws EntityNotFoundException, DatabaseException {
        try {
            return repository.findOne(id);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean isEmailExist(String email) throws DatabaseException {
        try {
            return repository.isEmailExist(email);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean isEmailExist(String email, Long excludedUserID) throws DatabaseException {
        try {
            return repository.isEmailExist(email, excludedUserID);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public User getByEmail(String email) throws DatabaseException {
        try {
            return repository.findByEmail(email);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<User> getAll() throws DatabaseException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<User> getAll(List<Long> excludedUserIDs) throws DatabaseException {
        try {
            return repository.findByIdNotIn(excludedUserIDs);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public void edit(User user) throws EntityNotFoundException, DatabaseException {
        if (!repository.exists(user.getId())) {
            throw new EntityNotFoundException();
        }

        try {
            repository.save(user);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public void removeByID(long id) throws EntityNotFoundException, DatabaseException {
        if (!repository.exists(id)) {
            throw new EntityNotFoundException();
        }
        try {
            repository.delete(id);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }
}
