package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.Doctor;

public interface IDoctorService {
	List<Doctor> findAllDoctors();
	public String updateDoctor( Doctor d, int id);
	public Optional<Doctor> deleteDoctor(int dId);
	public Doctor createDoctor(Doctor d);
	Optional<Doctor> findDoctorById(int id);
	List<Doctor> findDoctorByName(String name);
	public int getCountBydoctorName(String doctorName);
}
