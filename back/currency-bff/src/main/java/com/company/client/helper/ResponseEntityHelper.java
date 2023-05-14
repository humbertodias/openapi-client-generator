package com.company.client.helper;

import org.springframework.http.ResponseEntity;

public class ResponseEntityHelper {
    private ResponseEntityHelper(){

    }

    public static ResponseEntity<?> forward(ResponseEntity<?> responseEntity){
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }
}
