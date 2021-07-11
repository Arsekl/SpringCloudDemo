package UseeerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository repository;
    @PostMapping("/add")
    public void addUser(@RequestBody UserVO userVO){
        repository.save(new User(userVO.name, userVO.passwd));
    }
    @GetMapping("/{id}")
    public UserVO getUserById(@PathVariable Long id){
        User user = repository.findUserById(id);
        return new UserVO(user.getName(), user.getPasswd());
    }
}
