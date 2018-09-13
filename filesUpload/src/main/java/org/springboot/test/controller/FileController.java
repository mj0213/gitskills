package org.springboot.test.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
	
@Controller
public class FileController {

	@GetMapping("/file")
	public String fileUpload() {
		return "upload";
	}
	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,Model model) {
		if(!file.isEmpty()) {
			try {
				//文件上传到工程根路径
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
				out.write(file.getBytes());
				out.flush();
				out.close();
			} catch (Exception e) {
				 e .printStackTrace();
				 model.addAttribute("message", "上传失败");
			}
			model.addAttribute("message", "上传成功");
		}else {
			model.addAttribute("message", "上传失败，文件为空");
		}
		return "show";
	}
}
