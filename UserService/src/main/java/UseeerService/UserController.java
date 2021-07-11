package UseeerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository repository;
    @PostMapping("/add")
    public String addUser(@RequestBody UserVO userVO){
        repository.save(new User(userVO.name, userVO.passwd));
        return "Add Success";
    }
    @GetMapping("/{id}")
    public UserVO getUserById(@PathVariable long id){
        System.out.println(id);
        User user = repository.findUserById(id);
        return new UserVO(user.getName(), user.getPasswd());
    }
}
