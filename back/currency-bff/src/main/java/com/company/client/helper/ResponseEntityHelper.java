package com.company.client.helper;

import org.springframework.http.ResponseEntity;

public final class ResponseEntityHelper {
    private ResponseEntityHelper(){

    }

    public static ResponseEntity<?> forward(ResponseEntity<?> responseEntity){
        if (responseEntity == null) {
            throw new IllegalArgumentException("responseEntity cannot be null");
        }
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }
}
