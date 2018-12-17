package com.example.demo.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Owner;
import com.example.demo.service.PetClinicService;


@Controller
@RestController
@RequestMapping("/hsaglam")
public class ProductRestController {
	
	@Autowired
	private PetClinicService petClinicService;
	
	@RequestMapping(method=RequestMethod.POST , value="/hs")
	public ResponseEntity<URI> createOwner(@RequestBody Owner owner)
	{
		try {
		petClinicService.createOwner(owner);
		Long id=owner.getId();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
   }
	@RequestMapping(method=RequestMethod.GET , value="/bul")
	public ResponseEntity<List<Owner>> find()
	{
		List<Owner> owners = petClinicService.findOwners();
		return ResponseEntity.ok(owners);
	}
	
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/owner/{id}")
	public ResponseEntity<?> deleteOwner(@PathVariable("id") Long id) {
		try {
			petClinicService.deleteOwner(id);
			return ResponseEntity.ok().build();

		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
