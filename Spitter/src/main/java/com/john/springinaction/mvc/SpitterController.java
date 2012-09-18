package com.john.springinaction.mvc;

import com.john.springinaction.domain.Spitter;
import com.john.springinaction.domain.Spittle;
import com.john.springinaction.service.SpitterService;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

//import org.jets3t.service.security.AWSCredentials;

@Controller
@RequestMapping("/spitters")
public class SpitterController {
	
	@Resource(name = "spitterService")
	private SpitterService spitterService;
	
	@RequestMapping(value = "/spittles", method = RequestMethod.GET)
	public String listSpittlesForSpitter(
		@RequestParam("spitter") String username, Model model) {
		Spitter spitter = spitterService.getSpitter(username);
		List<Spittle> spittlesList = spitterService.getSpittlesForSpitter(username);
		model.addAttribute("spitter", spitter);
		model.addAttribute("spittlesList", spittlesList);
		return "spittles/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "new")
	public String createSpitterProfile(Model model) {
		model.addAttribute("spitter", new Spitter());
		return "spitters/edit";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String  addSpitterFromForm(@Valid Spitter spitter,
			BindingResult bindingResult,
			@RequestParam(value = "image", required = false)
			MultipartFile image) {
		if (bindingResult.hasErrors()) {
			return "spitters/edit";
		}
		spitterService.saveSpitter(spitter);
		try {			
			if (!image.isEmpty()) {
				validateImage(image);
				
				saveImage(spitter.getId() + ".jpg", image);
			}
		} catch (FileUploadException  e) {
			bindingResult.reject(e.getMessage());
			return "spitters/edit";
		}
		return "redirect:/spitters/" + spitter.getUsername();
	}
	


	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username,
		Model model){
		model.addAttribute("spitter", spitterService.getSpitter(username));
		return "spitters/view";
	}
	
	private void validateImage(MultipartFile image) throws FileUploadException {
		if (!image.getContentType().equals("image/jpeg")) {
			throw new FileUploadException("Ony JPG images accepted");
		}
		
	}
	
	private void saveImage(String string, MultipartFile image)
		throws FileUploadException{
		/*AWSCredentials awsCredentials = 
			new AWSCredentials("john", "ervine");
		try {
			File file = new File("../resources/" + filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e) {
			throw new ImageUploadException("Unable to save image" + e);
		}*/
	}
}
