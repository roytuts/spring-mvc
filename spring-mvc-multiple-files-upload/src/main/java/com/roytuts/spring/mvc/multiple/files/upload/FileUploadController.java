package com.roytuts.spring.mvc.multiple.files.upload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	private final String UPLOAD_FOLDER = "/upload";

	@GetMapping("/")
	public String uploadFiles() {
		return "uploadfiles";
	}

	@PostMapping("upload/files")
	public String handleFilesUpload(@RequestParam("files") MultipartFile files[], Model map) {
		StringBuilder sb = new StringBuilder();

		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				try {
					if (!Files.exists(Paths.get(UPLOAD_FOLDER))) {
						try {
							Files.createDirectories(Paths.get(UPLOAD_FOLDER));
						} catch (IOException ioe) {
							ioe.printStackTrace();
						}
					}

					Files.copy(file.getInputStream(), Paths.get(UPLOAD_FOLDER, file.getOriginalFilename()));
					sb.append("You successfully uploaded " + file.getOriginalFilename() + "!\n");

					map.addAttribute("msg", sb.toString());
				} catch (IOException | RuntimeException e) {
					sb.append("Failued to upload " + (file != null ? file.getOriginalFilename() : "") + " => "
							+ e.getMessage() + String.valueOf(e) + "\n");

					map.addAttribute("msg", sb.toString());
				}
			} else {
				sb.append("Failed to upload file\n");
				map.addAttribute("msg", sb.toString());
			}
		}

		return "uploadfiles";
	}

}
