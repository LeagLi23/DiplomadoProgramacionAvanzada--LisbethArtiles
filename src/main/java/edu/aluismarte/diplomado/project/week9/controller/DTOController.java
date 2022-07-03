package edu.aluismarte.diplomado.project.week9.controller;

import edu.aluismarte.diplomado.project.week9.network.request.CreateEmployeeRequest;
import edu.aluismarte.diplomado.project.week9.network.response.CreateEmployeeResponse;
import edu.aluismarte.diplomado.project.week9.network.response.GetEmployeesResponse;
import edu.aluismarte.diplomado.project.week9.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO adicionar las partes que tiene un controller bien implementado
 *
 * @author aluis on 6/26/2022.
 */
@RestController
@RequiredArgsConstructor
public class DTOController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<GetEmployeesResponse> getEmployees() {
        return ResponseEntity.ok(GetEmployeesResponse.builder()
                        .employees(employeeService.getEmployees())
                        .build());
    }

    @PostMapping
    public ResponseEntity<CreateEmployeeResponse> createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return ResponseEntity.ok(CreateEmployeeResponse.builder()
                .employee(employeeService.createEmployee(createEmployeeRequest))
                .build());
    }
}
