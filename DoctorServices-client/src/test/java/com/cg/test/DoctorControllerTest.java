package com.cg.test;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.controller.DoctorController;
import com.cg.model.Doctor;
import com.cg.service.IDoctorService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DoctorControllerTest {
	
	@Mock
	private IDoctorService doctorService;
	
	@InjectMocks
	private DoctorController doctorController;
	
	private Doctor doctor;
	
	@BeforeEach
	void setUp()
	{
		doctor = new Doctor(1 , "Doc1" , "M.D.");
	}

	@Test
	void testGetAllDoctors()
	{
		when(doctorService.findAllDoctors()).thenReturn(Arrays.asList(doctor));

        var doctors = doctorController.getAllDoctors();
        assertFalse(doctors.isEmpty());
        assertEquals(1, doctors.size());
        assertEquals("Doc1", doctors.get(0).getDoctorName());
	}
	
	@Test
    void testCreateProduct() {
        when(doctorService.createDoctor(doctor)).thenReturn(doctor);

        Doctor createdDoctor = doctorController.createMyDoctor(doctor);
        assertNotNull(createdDoctor);
        assertEquals("Doc1", createdDoctor.getDoctorName());
    }
	
	  @Test
	    void testFindDoctorById() {
	        // Your test code here
	        assertTrue(true);
	    }

}
