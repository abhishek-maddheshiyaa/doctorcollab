package com.cg.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.model.Doctor;
import com.cg.repository.DoctorRepository;

@Service
public class DoctorService implements IDoctorService {
	
	@Autowired
	DoctorRepository doctorRepo;
	
	public List<Doctor> findAllDoctors()
	{
		return doctorRepo.findAll();
	}
	
	public Optional<Doctor> findDoctorById(int dId)
	{
		return doctorRepo.findById(dId);
	}
	
	public Doctor createDoctor(Doctor d) {
		// TODO Auto-generated method stub
		return doctorRepo.save(d);
	}
	public Optional<Doctor> deleteDoctor(int dId) {
		// TODO Auto-generated method stub		
		Optional<Doctor> existingDoctor = doctorRepo.findById(dId);
		return existingDoctor;
	}
	
	public String updateDoctor( Doctor d, int id) {
	    if (doctorRepo.existsById(id)) {
	        Doctor doctor = new Doctor(); 
	        doctor.setId(id);
	        doctor.setDoctorName(d.getDoctorName());
	        doctor.setQualification(d.getQualification());;
	        doctorRepo.save(doctor); 
	        return "Doctor updated successfully";
	    } else {
	        return "Doctor ID not found";
	    }
	    
	}	
	
	public List<Doctor> findDoctorByName(String name) {
		// TODO Auto-generated method stub
		return doctorRepo.findAllBydoctorName(name);
	}

	public int getCountBydoctorName(String doctorName) {
		
		return doctorRepo.getCountBydoctorName(doctorName);
	}
}
