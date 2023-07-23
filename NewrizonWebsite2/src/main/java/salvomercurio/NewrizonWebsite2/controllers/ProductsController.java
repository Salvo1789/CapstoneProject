package salvomercurio.NewrizonWebsite2.controllers;

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

import salvomercurio.NewrizonWebsite2.entities.Product;
import salvomercurio.NewrizonWebsite2.payloads.ProductPayload;
import salvomercurio.NewrizonWebsite2.services.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	ProductsService productsService;

	@GetMapping("")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "0") double price1, @RequestParam(defaultValue = "1000") double price2) {
		return productsService.find(page, size, sortBy, price1, price2);
	}

	@PostMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody ProductPayload body) {
		return productsService.create(body);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Product getByIdAndUpdate(@PathVariable UUID id, @RequestBody ProductPayload body) {
		return productsService.findByIdAndUpdate(id, body);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Product getById(@PathVariable UUID id) throws Exception {
		return productsService.findById(id);
	}

	@GetMapping("/{name}")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Product getByName(@PathVariable String name) throws Exception {
		return productsService.findByName(name);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable UUID id) throws NotFoundException {
		productsService.findByIdAndDelete(id);
	}

}
