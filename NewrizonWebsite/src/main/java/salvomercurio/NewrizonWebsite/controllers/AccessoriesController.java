package salvomercurio.NewrizonWebsite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import salvomercurio.NewrizonWebsite.entities.Accessory;
import salvomercurio.NewrizonWebsite.services.AccessoriesService;

@RestController
@RequestMapping("/accessories")
public class AccessoriesController {

	@Autowired
	AccessoriesService accessoriesService;

	@PostMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Accessory> saveAccessories(@RequestBody List<Accessory> accessoriesList) {
		List<Accessory> accessoriesResponse = (List<Accessory>) accessoriesService.saveAccessories(accessoriesList);
		return accessoriesResponse;
	}
}
