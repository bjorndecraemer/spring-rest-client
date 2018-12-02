package bjorn.petprojects.springrestclientexamples.services;

import bjorn.petprojects.springrestclientexamples.api.domain.User;
import bjorn.petprojects.springrestclientexamples.api.domain.UserData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by bjorn on 02 Dec, 2018
 */
@Service
public class ApiServiceImpl implements ApiService{

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {
        UserData userData = restTemplate.getForObject("http://apifaketory.com/api/user?limit="+limit, UserData.class);
        return userData.getData();
    }
}
