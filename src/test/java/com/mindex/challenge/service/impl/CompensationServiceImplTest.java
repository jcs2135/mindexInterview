package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest {

    private String compensationUrl;
    private String compensationEmployeeUrl;

    @Autowired
    private CompensationService compensationService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        compensationUrl = "http://localhost:" + port + "/compensation";
        compensationEmployeeUrl = "http://localhost:" + port + "/compensation/{id}";
    }

    @Test
    public void testCreateRead() {
        Compensation testCompensation = new Compensation();
        testCompensation.setEmployee("16a596ae-edd3-4847-99fe-c4518e82c86f");
        testCompensation.setEffectiveDate("12/6/2023");
        testCompensation.setSalary(1000000);

        // Create check
        Compensation createdCompensation = restTemplate.postForEntity(compensationUrl, testCompensation, Compensation.class).getBody();

        assertNotNull(createdCompensation);
        assertCompensationEquivalence(createdCompensation, testCompensation);

        // Read check
        Compensation readCompensation = restTemplate.getForEntity(compensationEmployeeUrl, Compensation.class, createdCompensation.getEmployee()).getBody();
        assertNotNull(readCompensation);
        assertCompensationEquivalence(readCompensation, testCompensation);
    }

    private static void assertCompensationEquivalence(Compensation created, Compensation actual) {
        assertEquals(created.getEmployee(), actual.getEmployee());
        assertEquals(created.getEffectiveDate(), actual.getEffectiveDate());
        assertEquals(created.getSalary(), actual.getSalary());
    }
}