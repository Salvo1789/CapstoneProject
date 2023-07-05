package salvomercurio.NewrizonWebsite.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import salvomercurio.NewrizonWebsite.entities.Accessory;
import salvomercurio.NewrizonWebsite.payloads.NewAccessoryPayload;
import salvomercurio.NewrizonWebsite.services.AccessoriesService;
import salvomercurio.NewrizonWebsite.services.ModifiedAccessoryPayload;

@RestController
@RequestMapping("/accessories")
public class AccessoriesController {

	@Autowired
	AccessoriesService accessoriesService;

	@GetMapping("")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Page<Accessory> getAccessories(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "11") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "0") double price1, @RequestParam(defaultValue = "1000") double price2) {
		return accessoriesService.find(page, size, sortBy, price1, price2);
	}

	@PostMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public Accessory create(@RequestBody NewAccessoryPayload body) {
		return accessoriesService.create(body);

	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Accessory getByIdAndUpdate(@PathVariable UUID id, @RequestBody ModifiedAccessoryPayload body) {
		return accessoriesService.findByIdAndUpdate(id, body);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAccessory(@PathVariable UUID id) throws NotFoundException {
		accessoriesService.findByIdAndDelete(id);
	}
}
