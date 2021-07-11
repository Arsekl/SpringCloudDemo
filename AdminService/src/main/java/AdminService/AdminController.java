package AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    DiscoveryClient client;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/add")
    public String addUser(@RequestBody @Validated UserVO userVO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return bindingResult.getFieldError().getDefaultMessage();
        return restTemplate.postForObject("http://user-service/user/add", userVO, String.class);
    }
}
