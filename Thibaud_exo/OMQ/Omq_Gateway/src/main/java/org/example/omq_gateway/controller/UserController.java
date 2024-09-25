package org.example.omq_gateway.controller;

import org.example.omq_gateway.dto.userDto.UserDtoResponse;
import org.example.omq_gateway.tools.RestClient;
import org.example.omq_gateway.utils.PortApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class UserController {


    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> findUserById (@PathVariable int id){
        RestClient<UserDtoResponse> userRestClient = new RestClient<>("http://localhost:"+ PortApi.portUser +"/api/user/"+id);
        UserDtoResponse userDtoResponse = userRestClient.getRequest(UserDtoResponse.class);
        return new ResponseEntity<>(userDtoResponse, HttpStatus.OK);
    }
}
