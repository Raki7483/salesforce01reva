package com.example.demo.controller;

import com.example.demo.entity.MallAdmin;
import com.example.demo.service.MallAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")  // 👈 Base URL
public class MallAdminController {

    @Autowired
    private MallAdminService service;

    // CREATE
    @PostMapping
    public MallAdmin createAdmin(@RequestBody MallAdmin admin) {
        return service.saveAdmin(admin);
    }

    // READ all
    @GetMapping
    public List<MallAdmin> getAllAdmins() {
        return service.getAllAdmins();
    }

    // READ one
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getItem(@PathVariable("id") Integer itemId) {
        return ResponseEntity.ok("Item id: " + itemId);
    }


    // UPDATE
    @PutMapping("/{id}")
    public MallAdmin updateAdmin(@PathVariable Integer id, @RequestBody MallAdmin admin) {
        return service.updateAdmin(id, admin);
    }

    // DELETE
    @DeleteMapping("deleteid/{id}")
    public void deleteAdmin(@PathVariable Integer id) {
        service.deleteAdmin(id);
    }
}
