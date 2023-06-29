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

import salvomercurio.NewrizonWebsite.entities.Smartphone;
import salvomercurio.NewrizonWebsite.payloads.ModifiedSmartphonePayload;
import salvomercurio.NewrizonWebsite.payloads.NewSmartphonePayload;
import salvomercurio.NewrizonWebsite.services.SmartphonesService;

@RestController
@RequestMapping("/smartphones")
public class SmartphonesController {
	@Autowired
	SmartphonesService smartphonesService;

	@GetMapping("")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Page<Smartphone> getSmartphones(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "") String display, @RequestParam(defaultValue = "0") int ram,
			@RequestParam(defaultValue = "0") int rom, @RequestParam(defaultValue = "") String os,
			@RequestParam(defaultValue = "0") double price1, @RequestParam(defaultValue = "1000") double price2) {
		return smartphonesService.find(page, size, sortBy, display, ram, rom, os, price1, price2);
	}

	@PostMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public Smartphone createSmartphone(@RequestBody NewSmartphonePayload body) {
		return smartphonesService.create(body);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Smartphone getByIdAndUpdate(@PathVariable UUID id, @RequestBody ModifiedSmartphonePayload body) {
		return smartphonesService.findByIdAndUpdate(id, body);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Smartphone getById(@PathVariable UUID id) throws Exception {
		return smartphonesService.findById(id);
	}

	@GetMapping("/{name}")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Smartphone getByName(@PathVariable String name) throws Exception {
		return smartphonesService.findByName(name);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteFattura(@PathVariable UUID id) throws NotFoundException {
		smartphonesService.findByIdAndDelete(id);
	}

}
