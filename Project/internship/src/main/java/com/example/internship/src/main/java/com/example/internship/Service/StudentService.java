package com.example.internship.Service;

import com.example.internship.Entity.*;
import com.example.internship.Repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public InternshipRepo internshipRepo;
    public ApplicationRepo applicationRepo;
    public ResumeRepo resumeRepo;
    public OfferLetterRepo offerLetterRepo;
    public StudentProfileRepo studentProfileRepo;

    public StudentService(InternshipRepo internshipRepo, ApplicationRepo applicationRepo, ResumeRepo resumeRepo,
                          OfferLetterRepo offerLetterRepo, StudentProfileRepo studentProfileRepo) {
        this.internshipRepo = internshipRepo;
        this.applicationRepo = applicationRepo;
        this.resumeRepo = resumeRepo;
        this.offerLetterRepo = offerLetterRepo;
        this.studentProfileRepo = studentProfileRepo;
    }

    public List<Internship> getAllInternships() {
        return internshipRepo.getAll();
    }

    public void apply(Application app) {
        applicationRepo.insert(app);
    }

    public List<Application> getApplications(int studentId) {
        return applicationRepo.getByStudentId(studentId);
    }

    public void uploadResume(Resume resume) {
        resumeRepo.insert(resume);
    }

    public List<Resume> getResumesByStudent(int studentId) {
        return resumeRepo.getByStudentId(studentId);
    }

    public List<OfferLetter> getOfferLetters(int studentId) {
        return offerLetterRepo.getByStudentId(studentId);
    }

    public StudentProfile getStudentProfile(int userId) {
        return studentProfileRepo.getByUserId(userId);
    }

    public void updateStudentProfile(StudentProfile sp) {
        studentProfileRepo.update(sp);
    }

    public List<Internship> searchInternships(String keyword) {
        return internshipRepo.searchByTitle(keyword);
    }

    public List<Internship> getDeadlineReminders(LocalDate date) {
        return internshipRepo.getUpcomingDeadlines(date);
    }
}