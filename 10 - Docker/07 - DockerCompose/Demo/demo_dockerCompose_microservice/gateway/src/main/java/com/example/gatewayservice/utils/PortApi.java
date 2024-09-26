package com.example.gatewayservice.utils;

import org.springframework.beans.factory.annotation.Value;

public class PortApi {

//    @Value("${PORT_AUTH}")
    @Value("${PORT_AUTH:8085}")
    public static String portAuth ;
//    @Value("${Port_USER")
    @Value("${PORT_USER:8083}")
    public static String portUser ;
//    @Value("${PORT_COMM}")
    @Value("${PORT_COMM:8084}")
    public static String portComm  ;
//    @Value("${PORT_CAR_RIDE}")
    @Value("${PORT_CAR_RIDE:8082}")
    public static String portCarRide ;


}
