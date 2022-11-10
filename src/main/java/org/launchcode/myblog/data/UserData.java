package org.launchcode.myblog.data;

import org.launchcode.myblog.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserData extends CrudRepository<User, Integer> {
}
