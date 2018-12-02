package bjorn.petprojects.springrestclientexamples.services;

import bjorn.petprojects.springrestclientexamples.api.domain.User;
import bjorn.petprojects.springrestclientexamples.api.domain.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by bjorn on 02 Dec, 2018
 */
@Service
public class ApiServiceImpl implements ApiService{

    private RestTemplate restTemplate;
    private String api_url;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
        System.out.println(api_url);
    }

    @Override
    public List<User> getUsers(Integer limit) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("limit", limit);
        UserData userData = restTemplate.getForObject(uriBuilder.toUriString(), UserData.class);
        return userData.getData();
    }
}
