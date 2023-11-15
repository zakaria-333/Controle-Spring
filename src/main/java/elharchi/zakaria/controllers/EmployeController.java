package elharchi.zakaria.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import elharchi.zakaria.entities.Employe;
import elharchi.zakaria.services.EmployeService;


@RestController
@RequestMapping("/api/employe")
public class EmployeController {
	
	@Autowired
	private EmployeService employeService;
	

	@GetMapping
	public List<Employe> findAllEmploye(){
		return employeService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Employe employe = employeService.findById(id);
		if(employe == null) {
			return new ResponseEntity<Object>("Employe with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(employe);
		}
	}
	
	@PostMapping
	public Employe createEmploye(@RequestBody Employe employe) {
		employe.setId(0L);
		return employeService.create(employe);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmploye(@PathVariable Long id,@RequestBody Employe employe) {
		if(employeService.findById(id) == null) {
			return new ResponseEntity<Object>("Employe with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			employeService.update(id, employe);
			Map<String, String> response = new HashMap<>();
	        response.put("message", "update avec succès");
	        return ResponseEntity.ok(response);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmploye(@PathVariable Long id){
		Employe employe = employeService.findById(id);
		if(employe == null) {
			return new ResponseEntity<Object>("Employe with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			employeService.delete(employe);
			return ResponseEntity.ok("Employe has been deleted");
		}
	}
	
//	@GetMapping("service/{id}")
//	public ResponseEntity<Object> getEmployesByService(@PathVariable Long id) {
//	    List<Employe> employ = employeService.FindEmployeesByService();
//	}
}
