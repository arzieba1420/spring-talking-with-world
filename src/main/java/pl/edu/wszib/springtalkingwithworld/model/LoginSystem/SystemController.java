package pl.edu.wszib.springtalkingwithworld.model.LoginSystem;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/system")
public class SystemController {

    private Map<String,String> users = new HashMap<>();
    private Set<String> activeUsers = new HashSet<String>();  //logins of active users
    private Map<String, User> sessions = new HashMap<>();

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserDTO userDTO){

        if(users.containsKey(userDTO.login)){
            return new ResponseEntity("User "+userDTO.login+" already exists",HttpStatus.ALREADY_REPORTED);
        } else if( userDTO.confirm.equals(userDTO.password)){
            users.put(userDTO.login,userDTO.password);
            return ResponseEntity.ok("User has been registered");
        }

       else return new ResponseEntity("Register failed", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO){

        if(activeUsers.contains(userDTO.login)){
            return new ResponseEntity("Session for this user is active!", HttpStatus.FOUND);
        }
        if(users.containsKey(userDTO.login) && users.get(userDTO.login).equals(userDTO.password) ){
            String sessionId = String.valueOf( new Random().nextInt());
            User user = convert(userDTO);
            user.setSessionID(sessionId);
            activeUsers.add(user.getLogin());
            sessions.put(sessionId,user);
            return ResponseEntity.ok("Login succesful! Your session code: "+sessionId);
        }
        else return new ResponseEntity("Login failed",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/activeSessions")
    public ResponseEntity getActiveSessions(){

        List<String> sessId = new ArrayList<>(sessions.keySet());
        List<String> sessLog = new ArrayList (sessions.values());


        String response="";
        for (int i=0;i<sessId.size();i++){
            response=response+"session ID "+sessId.get(i)+" User: "+sessions.get(sessId.get(i)).getLogin()+"\n";
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity logoutFromSession(@RequestBody SessionIdDTO sessionIdDTO){
        if(sessions.containsKey(sessionIdDTO.sessionID)){
            activeUsers.remove(sessions.get(sessionIdDTO.sessionID).getLogin());
            sessions.remove(sessionIdDTO.sessionID);

            return ResponseEntity.ok("Logout succesful");
        } else return new ResponseEntity("Session is not active or does not exist", HttpStatus.UNAUTHORIZED);

    }

    public UserDTO convert(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.login=user.getLogin();
        userDTO.password=user.getPassword();
        return userDTO;
    }

    public User convert(UserDTO userDTO){
        User user = new User();
        user.setLogin(userDTO.login);
        user.setPassword(userDTO.password);
        return user;
    }

}
