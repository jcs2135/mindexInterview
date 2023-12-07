package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Compensation Service that is used to create and read from the MongoDB database
 */
@Service
public class CompensationServiceImpl implements CompensationService {

    // The logger for this class
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    // The Autowired repository for the Compensation
    @Autowired
    private CompensationRepository compensationRepository;

    /**
     * Creates a Compensation by inserting it into the repository
     * @param compensation the Compensation to be put in the MongoDB database
     * @return the Compensation that was inserted into the Database
     */
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation [{}]", compensation);

        return compensationRepository.insert(compensation);
    }

    /**
     * Reads a Compensation from the repository
     * @param id the Employee ID to read from the repository
     * @return the Compensation from the Employee ID
     */
    @Override
    public Compensation read(String id) {
        LOG.debug("Finding compensation with id [{}]", id);

        Compensation compensation = compensationRepository.findCompensationByEmployee(id);

        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensation;
    }
}
