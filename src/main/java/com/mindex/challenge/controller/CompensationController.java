package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Compensation controller
 * Contains the endpoints to create and read compensations
 */
@RestController
public class CompensationController {

    // The log for the Compensation Controller
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    // The Compensation Service that is Autowired by Spring Boot
    @Autowired
    private CompensationService compensationService;

    /**
     * Responds to the POST mapping of "/compensation" to create a new Compensation
     * @param compensation the body of the post to use to create the compensation from
     * @return the newly created Compensation
     */
    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received compensation create request for [{}]", compensation);

        return compensationService.create(compensation);
    }

    /**
     * Responds to the GET mapping of "/compensation/{id}" to retrieve a Compensation
     * @param id the Employee ID of the compensation that is wanted
     * @return the Compensation of the Employee ID
     */
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received compensation read for id [{}]", id);

        return compensationService.read(id);
    }
}
