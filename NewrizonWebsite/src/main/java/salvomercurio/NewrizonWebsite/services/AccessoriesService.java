package salvomercurio.NewrizonWebsite.services;

import java.util.List;

import org.springframework.stereotype.Component;

import salvomercurio.NewrizonWebsite.entities.Accessory;

@Component
public interface AccessoriesService {
	public List<Accessory> saveAccessories(List<Accessory> accessoriesList);
}
