package com.cg.dto;

import com.cg.model.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
	
	private int id;
	private String doctorName;
	private String qualification;
	
	
	public static DoctorDTO fromEntity(Doctor doctor)
	{
		return new DoctorDTO(doctor.getId(),doctor.getDoctorName(),doctor.getQualification());
	}
	
	public Doctor toEntity()    
	{
		return new Doctor(this.id,this.doctorName,this.qualification); 
	}

}
