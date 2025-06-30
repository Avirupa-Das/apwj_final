package com.example.internship.Service;

import com.example.internship.Entity.Application;
import com.example.internship.Entity.CompanyProfile;
import com.example.internship.Entity.Internship;
import com.example.internship.Entity.OfferLetter;
import com.example.internship.Repository.ApplicationRepo;
import com.example.internship.Repository.CompanyProfileRepo;
import com.example.internship.Repository.InternshipRepo;
import com.example.internship.Repository.OfferLetterRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    public InternshipRepo internshipRepo;
    public ApplicationRepo applicationRepo;
    public CompanyProfileRepo companyProfileRepo;
    public OfferLetterRepo offerLetterRepo;

    public CompanyService(InternshipRepo internshipRepo, ApplicationRepo applicationRepo,
                          CompanyProfileRepo companyProfileRepo, OfferLetterRepo offerLetterRepo) {
        this.internshipRepo = internshipRepo;
        this.applicationRepo = applicationRepo;
        this.companyProfileRepo = companyProfileRepo;
        this.offerLetterRepo = offerLetterRepo;
    }

    public void postInternship(Internship i) {
        internshipRepo.insert(i);
    }

    public void updateInternship(Internship i) {
        internshipRepo.update(i);
    }

    public void deleteInternship(int internshipId) {
        internshipRepo.delete(internshipId);
    }

    public List<Application> viewApplicants(int internshipId) {
        return applicationRepo.getByInternshipId(internshipId);
    }

    public void changeApplicationStatus(int applicationId, int statusId) {
        applicationRepo.updateStatus(applicationId, statusId);
    }

    public CompanyProfile getCompanyProfile(int userId) {
        return companyProfileRepo.getByUserId(userId);
    }

    public void updateCompanyProfile(CompanyProfile cp) {
        companyProfileRepo.update(cp);
    }

    public void sendOfferLetter(OfferLetter letter) {
        offerLetterRepo.insert(letter);
    }

    public List<OfferLetter> getOfferLettersByCompany(int companyId) {
        return offerLetterRepo.getByCompanyId(companyId);
    }
}