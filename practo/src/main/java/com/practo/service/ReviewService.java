package com.practo.service;

import com.practo.entity.Doctor;
import com.practo.entity.Patient;
import com.practo.entity.Review;
import com.practo.repository.DoctorRepository;
import com.practo.repository.PatientRepository;
import com.practo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(Review review){
       Doctor doctor = doctorRepository.findById(review.getDoctorId()).get();
       Patient  patient = patientRepository.findById(review.getPatientId()).get();

        Review savedReview =null;

       if(doctor!=null || patient!=null){
           reviewRepository.save(review);

       }
       return savedReview;
    }
    public List<Review> getReviewByDoctorId(long doctorId){
        List<Review> reviews = reviewRepository.findByDoctorId(doctorId);
        return reviews;
    }


}
