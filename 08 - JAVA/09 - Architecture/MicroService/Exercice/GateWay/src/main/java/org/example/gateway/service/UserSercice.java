package org.example.gateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.Dto.user.UserDtoSend;
import org.example.gateway.Dto.user.UserDtoReceive;
import org.example.gateway.util.RestClient;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserSercice {

    private ObjectMapper om;

    public UserSercice() {
        this.om =  new ObjectMapper();
    }

    public UserDtoSend saveUser(UserDtoReceive user) throws JsonProcessingException {
        RestClient<UserDtoSend> userClient = new RestClient<>("http://localhost:8081/api/user");
        return userClient.postRequest(om.writeValueAsString(user),UserDtoSend.class);
    }

    public UserDtoSend getById (long id){
        RestClient<UserDtoSend> userClient = new RestClient<>("http://localhost:8081/api/user/"+id);
        return userClient.getRequest(UserDtoSend.class);
    }

    public List<UserDtoSend> getAll (){
        RestClient<UserDtoSend[]> userClient = new RestClient<>("http://localhost:8081/api/user");
        return Arrays.stream(userClient.getRequest(UserDtoSend[].class)).toList();
    }
}
