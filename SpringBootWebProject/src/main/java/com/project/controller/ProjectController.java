package com.project.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.dao.ProjectDAO;
import com.project.model.Registration;

@Controller
public class ProjectController {

	@Autowired
	ProjectDAO projectDAO;

	@GetMapping("/registration")
	public String registraitonView() {
		return "Registration";
	}

	@PostMapping("/saveUser")
	public String saveUserInfo(Registration user, @RequestParam("profileImage") MultipartFile file) {

		try {
			if (file.isEmpty()) {
				System.out.println("File Empty");
			} else {
				user.setImageURL(file.getOriginalFilename());
				System.out.println(new ClassPathResource("").getFile().getAbsolutePath());
				File newFile = new ClassPathResource("static/img").getFile();
				Path path=Paths.get(newFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
				Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
			}
			projectDAO.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/registration";
	}
}
