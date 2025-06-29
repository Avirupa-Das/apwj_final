package com.example.internship.Repository;

import com.example.internship.Entity.Resume;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ResumeRepo {
    public final JdbcTemplate jdbc;

    public String GetByStudentId = "SELECT * FROM resume WHERE student_id=?";
    public String GetByCompanyId = "SELECT * FROM resume WHERE company_id=?";
    public String Insert = "INSERT INTO resume (student_id, company_id, resume_location, uploaded_date) VALUES (?, ?, ?, ?)";

    public ResumeRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Resume> getByStudentId(int studentId) {
        return jdbc.query(GetByStudentId, new Object[]{studentId}, new BeanPropertyRowMapper<>(Resume.class));
    }

    public List<Resume> getByCompanyId(int companyId) {
        return jdbc.query(GetByCompanyId, new Object[]{companyId}, new BeanPropertyRowMapper<>(Resume.class));
    }

    public void insert(Resume r) {
        jdbc.update(Insert, r.getStudentId(), r.getCompanyId(), r.getResumeLocation(), r.getUploadedDate());
    }
}
