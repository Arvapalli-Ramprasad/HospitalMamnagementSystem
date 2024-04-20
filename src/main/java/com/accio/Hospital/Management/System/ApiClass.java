package com.accio.Hospital.Management.System;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ApiClass {

    HashMap<Integer,Patient> patientDb = new HashMap<>();

    @GetMapping("getReport")
    public static String getWeatherUpdates(){
        return "the temp is 100 degree now";
    }

    @GetMapping("addition")
    public static String add(@RequestParam("n1") int n1,@RequestParam("n2") int n2,@RequestParam("operator") char ch){
        if(ch=='+'){
            int sum = n1+n2;
            return "the sum is "+sum;
        }
        else if(ch=='-'){
            int sub = n1-n2;
            return "the sub is "+sub;
        }
        else if(ch=='/') {
            int div = n1/n2;
            return "the div is " +div;
        }
        else{
            int mul = n1*n2;
            return "the mul is "+mul;
        }

    }

    @PostMapping("addingPatientInfo")
    public String addPatient(@RequestBody Patient patient){
        int key = patient.getPatientId();
        patientDb.put(key,patient);
        return "patient added successfully";
    }

    @GetMapping("getPatientInfo")

    public Patient getPatientInfo(@RequestParam("patientId") int key){
        Patient patientInfo = patientDb.get(key);
        return patientInfo;
    }

    @GetMapping("getPatientByNameAndMobileNumber")
    public Patient getPatientBynameAndMobNo(@RequestParam("patientName") String patientName,
                                            @RequestParam("patientMobileNumber") Long mobileNumber){
        for(Patient patient: patientDb.values()){
            if(patient.getPatientName().equals(patientName) && patient.getMobileNumber().equals(mobileNumber)){
                return patient;
            }
        }
        return null;
    }
}
