package com.example.crudapplication.controller;

import com.example.crudapplication.model.Employee;
import com.example.crudapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //display list of employees
    @RequestMapping("/home")
    public String viewHomePage(Model model){
        model.addAttribute("ListEmployees" , employeeService.getAlEmployees());
        return "index";
    }

    @GetMapping("/showNewEmployee")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "add_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save Employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/home";
    }

    @RequestMapping("/showFormUpdate")
    public String showFormForUpdate(@RequestParam(value = "id") long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee" , employee);
        return "update_employee";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam(value = "id") long id){
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/home";
    }

}
