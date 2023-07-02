package salvomercurio.NewrizonWebsite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import salvomercurio.NewrizonWebsite.entities.Accessory;
import salvomercurio.NewrizonWebsite.services.AccessoriesService;

@RestController
@RequestMapping("/accessories")
public class AccessoriesController {

	@Autowired
	AccessoriesService accessoriesService;

	@GetMapping("")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Page<Accessory> getAccessories(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "0") double price1, @RequestParam(defaultValue = "1000") double price2) {
		return accessoriesService.find(page, size, sortBy, price1, price2);
	}

	@PostMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Accessory> saveAccessories(List<Accessory> accList) {
		List<Accessory> accessoriesResponse = accessoriesService.saveAccessories(accList);
		return accessoriesResponse;
	}
}
