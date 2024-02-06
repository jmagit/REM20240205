package com.example.application.resources;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@RestController
@RequestMapping("/cotilla/v1")
public class CotillaResource {

	@GetMapping(path = "/primero/{id}")
	public String primero(@PathVariable String id,
	        @RequestParam String nom,
	        @RequestHeader("Accept-Language") String language, 
	        @CookieValue(name = "JSESSIONID", required = false) String cookie) { 
	    StringBuilder sb = new StringBuilder();
	    sb.append("id: " + id + "\n");
	    sb.append("nom: " + nom + "\n");
	    sb.append("language: " + language + "\n");
	    sb.append("cookie: " + cookie + "\n");
	    return sb.toString();
	}

	@Data @AllArgsConstructor @NoArgsConstructor
	class MiDTO {
		private int id;
		private String nombre;
		private String apellidos;
	}
	
	@GetMapping(path = "/dto/{id}")
	public MiDTO conDTO(@PathVariable int id) { 
	    
	    return new MiDTO(id, "Pepito", "Grillo");
	}

}
