package bjorn.petprojects.springrestclientexamples.services;

import bjorn.petprojects.springrestclientexamples.api.domain.User;

import java.util.List;

/**
 * Created by bjorn on Dec, 2018
 */
public interface ApiService {
    List<User> getUsers(Integer limit);
}
