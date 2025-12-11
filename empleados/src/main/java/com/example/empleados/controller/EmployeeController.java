package com.example.empleados.controller;

import com.example.empleados.model.Employee;
import com.example.empleados.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.empleados.model.Employee;
import com.example.empleados.service.EmployeeService;


@Controller
@RequestMapping("/empleados")
public class EmployeeController {



private final EmployeeService service;
public EmployeeController(EmployeeService service) {
this.service = service;
}
@GetMapping("/list")
public String list(Model model) {
model.addAttribute("empleados", service.findAll());
return "empleados-list";
}
@GetMapping("/nuevo")
public String nuevo(Model model) {
model.addAttribute("empleado", new Employee());
return "empleados-form";
}
@PostMapping("/save")
public String save(@ModelAttribute("empleado") Employee employee) {
service.save(employee);
return "redirect:/empleados/list";
}
@GetMapping("/editar/{id}")
public String editar(@PathVariable Long id, Model model) {
Employee emp = service.findById(id);
model.addAttribute("empleado", emp);
return "empleados-form";
}
@GetMapping("/delete/{id}")
public String delete(@PathVariable Long id) {
service.delete(id);
return "redirect:/empleados/list";
}




}
