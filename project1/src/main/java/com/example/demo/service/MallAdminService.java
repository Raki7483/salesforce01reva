package com.example.demo.service;

import com.example.demo.entity.MallAdmin;
import com.example.demo.repository.MallAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallAdminService {

    @Autowired
    private MallAdminRepository repository;

    // CREATE
    public MallAdmin saveAdmin(MallAdmin admin) {
        return repository.save(admin);
    }

    // READ all
    public List<MallAdmin> getAllAdmins() {
        return repository.findAll();
    }

    // READ by id
    public MallAdmin getAdminById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id " + id));
    }

    // UPDATE by id
    public MallAdmin updateAdmin(Integer id, MallAdmin details) {
        MallAdmin admin = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id " + id));

        // update only the fields
        admin.setName(details.getName());
        admin.setEmail(details.getEmail());
        admin.setPassword(details.getPassword());

        return repository.save(admin); // managed entity -> safe update
    }

    // DELETE by id
    public void deleteAdmin(int id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Admin not found with id " + id);
        }
        repository.deleteById(id); // safe delete
    }
}