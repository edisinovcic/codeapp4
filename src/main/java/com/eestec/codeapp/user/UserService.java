package com.eestec.codeapp.user;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> fetchAll();

    public Optional<User> fetchOne(Long id);

    public Optional<User> save(UserDto userDto);

    public void delete(Long id);

    public void deleteAll();

}
