package com.Numitry.in.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Numitry.in.Entity.Employee;
import com.Numitry.in.Repository.EmployeeRepository;
import com.Numitry.in.util.PDFGenerator;

@RestController
@RequestMapping("/api/pdf")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/employees", produces = 
                            MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> employeeReport() 
                                throws IOException {
        List<Employee> employees = (List<Employee>) employeeRepository.
                                                 findAll();

        ByteArrayInputStream bis = PDFGenerator
                           .employeePDFReport(employees);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=employees.pdf");

        return ResponseEntity.ok().headers(headers).contentType
                               (MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
    
    @PostMapping("/add")
    ResponseEntity<Employee> addEmp(@RequestBody Employee emp) {
    	 return ResponseEntity.ok(employeeRepository.save(emp));
    }
}
