package bjorn.petprojects.springrestclientexamples.controllers;

import bjorn.petprojects.springrestclientexamples.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

/**
 * Created by bjorn on 02 Dec, 2018
 */
@Slf4j
@Controller
public class UserController {

    private final ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"","/","/index"})
    public String getIndex(){
        return "index";
    }

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange){
        MultiValueMap<String,String> map = serverWebExchange.getFormData().block();

        Integer limit = new Integer(map.get("limit").get(0));
        log.debug("Received limit value : "+limit);

        if(limit == null || limit <= 0){
            log.debug("Setting limit to default of 10");
            limit = 10;
        }

        model.addAttribute("users",apiService.getUsers(limit));
        return "userlist";
    }
}
