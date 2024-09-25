package org.example.omq_gateway.controller.logedController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.omq_gateway.dto.userDto.UserDtoRequest;
import org.example.omq_gateway.dto.userDto.UserDtoResponse;
import org.example.omq_gateway.tools.RestClient;
import org.example.omq_gateway.utils.PortApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class UserControllerLoged {

    private final ObjectMapper om;

    public UserControllerLoged() {
        this.om = new ObjectMapper();
    }

    @PostMapping("/finduser")
    public ResponseEntity<UserDtoResponse> findUser (@RequestBody UserDtoRequest userDtoRequest) throws JsonProcessingException {
        RestClient<UserDtoResponse> userRestClient = new RestClient<>("http://localhost:"+ PortApi.portUser +"/api/user/findbyemail");
        UserDtoResponse userDtoResponse = userRestClient.postRequest(om.writeValueAsString(userDtoRequest),UserDtoResponse.class);
        return new ResponseEntity<>(userDtoResponse, HttpStatus.OK);
    }
}
