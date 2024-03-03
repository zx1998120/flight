package com.example.controller;

// ClientSoftwareController.java

import com.example.data.Flight;
import com.example.object.ApiResponse;
import com.example.object.SearchParameters;
import com.example.object.SearchRequest;
import com.example.service.LockService;
import com.example.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class ClientSoftwareController {

    @Autowired
    private LockService lockService;

    @Autowired
    private QueryService queryService;

    @PostMapping("/search")
    public ResponseEntity<?> search(@RequestBody SearchRequest request, @RequestParam(required = false) String sortBy) {
        // Step 1: Acquire lock
        boolean lockAcquired = lockService.acquireLock(request.getFlightId());
        if (!lockAcquired) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to acquire lock");
        }

        try {
            // Step 2: Generate search parameters
            SearchParameters params = generateSearchParameters(request);
            System.out.println("debug test");
            System.out.println(params);
            if (params == null) {
                return ResponseEntity.badRequest().body("Invalid input");
            }

            // Step 3: Launch query
            List<Flight> response = queryService.executeQuery(params);
            if (sortBy != null) {
                switch (sortBy) {
                    case "departTime":
                        Collections.sort(response, Comparator.comparing(Flight::getDepartDateTime));
                        break;
                    case "arriveTime":
                        Collections.sort(response, Comparator.comparing(Flight::getArriveDateTime));
                        break;
                    case "travelTime":
                        Collections.sort(response, Comparator.comparing(Flight::getTravelTime));
                        break;
                    default:
                        return ResponseEntity.badRequest().body("Invalid sorting parameter");
                }
            }
            return ResponseEntity.ok(response);

        } finally {
            // Step 6: Release lock
            lockService.releaseLock(request.getFlightId());
        }
    }

    private SearchParameters generateSearchParameters(SearchRequest request) {
        String departAirport = request.getDepartAirport();
        String arriveAirport = request.getArriveAirport();
        if (departAirport == null || arriveAirport == null || departAirport.isEmpty() || arriveAirport.isEmpty()){
            return null;
        }
        SearchParameters params = new SearchParameters();
        params.setDepartAirport(departAirport);
        params.setArriveAirport(arriveAirport);
        return params;
    }
}


