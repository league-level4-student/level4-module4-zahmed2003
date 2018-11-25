package _04_hospital;

import java.util.ArrayList;
import java.util.Stack;

public class Hospital {
	
	ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	ArrayList<Patient> patients = new ArrayList<Patient>();

	public void addDoctor(Doctor d) {
		doctors.add(d);
		
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public void addPatient(Patient p) {
		patients.add(p);
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void assignPatientsToDoctors() {
		int remain = patients.size()%3;
		int doc = (patients.size() - remain)/3 + 1;
		
		Stack<Patient> temp = new Stack<Patient>();
		
		for(int i = patients.size() - 1; i >= 0; i--)
		{
			temp.push(patients.get(i));
		}
		
		for(int i = 0; i < doc; i++)
		{
			if(i == doc - 1)
			{
				for(int j = 0; j < remain; j++) {
					try {
					doctors.get(i).assignPatient(temp.pop());
				} catch (DoctorFullException e) {
					e.printStackTrace();
				}
					}
			}
			else
			{
				for(int j = 0; j < 3; j++) {
					try {
					doctors.get(i).assignPatient(temp.pop());
				} catch (DoctorFullException e) {
					e.printStackTrace();
				}
			}
			}
		}
		
		
	}

}
