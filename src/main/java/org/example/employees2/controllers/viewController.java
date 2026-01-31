package org.example.employees2.controllers;

import org.example.employees2.models.dao.DeptEntityDAO;
import org.example.employees2.models.dao.EmployeeEntityDAO;
import org.example.employees2.models.entities.DeptEntity;
import org.example.employees2.models.entities.EmployeeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
class viewController {

    private final DeptEntityDAO deptEntityDAO;
    private final EmployeeEntityDAO employeeEntityDAO;

    viewController(DeptEntityDAO deptEntityDAO, EmployeeEntityDAO employeeEntityDAO) {
        this.deptEntityDAO = deptEntityDAO;
        this.employeeEntityDAO = employeeEntityDAO;
    }

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/verdepartamentos")
    public String verdepartamentos(Model model) {
        List<DeptEntity> departs = (List<DeptEntity>) deptEntityDAO.findAll();
        model.addAttribute("departamentos", departs);
        return "verdepartamentos";
    }

    @GetMapping("/altadepartamento")
    public String altadepartamentos(Model model) {
        model.addAttribute("departamento", new DeptEntity());
        return "altadepartamento";
    }

    @PostMapping("/altadepartamento")
    public String crearDepartamentos(@ModelAttribute DeptEntity deptEntity, Model model) {
        if(!deptEntityDAO.existsById(deptEntity.getId())) {
            deptEntityDAO.save(deptEntity);
            model.addAttribute("tipo_operacion", "ok");
            model.addAttribute("message", "Departamento creado correctamente");
        }
        else{
            model.addAttribute("tipo_operacion", "error");
            model.addAttribute("message", "Error al crear el departamente: ya existe");
        }
        return "altadepartamento";
    }

    @PostMapping("/altadepartamento")
    public String updateDepartamentos(@ModelAttribute DeptEntity deptEntity, Model model) {
        if(deptEntityDAO.existsById(deptEntity.getId())) {
            DeptEntity newDept = new DeptEntity();
            newDept.setId(deptEntity.getId());
            newDept.setDname(deptEntity.getDname());
            newDept.setLoc(deptEntity.getLoc());
            deptEntityDAO.save(newDept);
            model.addAttribute("tipo_operacion", "ok");
            model.addAttribute("message", "Departamento actualizado correctamente");
        }
        else{
            model.addAttribute("tipo_operacion", "error");
            model.addAttribute("message", "Error al actualizar el departamente");
        }
        return "altadepartamento";
    }

    @GetMapping("/verempleados")
    public String verempleados(Model model) {
        List<EmployeeEntity> employees = (List<EmployeeEntity>) employeeEntityDAO.findAll();
        model.addAttribute("empleados", employees);
        return "verempleados";
    }

    @GetMapping("/verempleado")
    public String verempleado(Model model, @RequestParam(name = "empno", required = true) int id) {
        Optional<EmployeeEntity> employee = employeeEntityDAO.findById(id);
        if(!employee.isPresent()) {
            model.addAttribute("tipo_operacion", "error");
            model.addAttribute("message", "No se encontró al empleado con id: " + id);
            return "error";
        }
        model.addAttribute("empleado", employee.get());
        return "verempleados";
    }

    @GetMapping("/altaempleado")
    public String altaempleado(Model model) {
        model.addAttribute("empleado", new EmployeeEntity());
        return "altaempleado";
    }

    @PostMapping("/altaempleado")
    public String crearEmpleado(@ModelAttribute EmployeeEntity employeeEntity, Model model) {
        if(!employeeEntityDAO.existsById(employeeEntity.getId())) {
            employeeEntityDAO.save(employeeEntity);
            model.addAttribute("tipo_operacion", "ok");
            model.addAttribute("message", "Empleado creado correctamente");
        }
        else{
            model.addAttribute("tipo_operacion", "error");
            model.addAttribute("message", "Error al crear el empleado: ya existe");
        }
        return "altaempleado";
    }

    @PostMapping("/altaempleado")
    public String updateEmpleado(@ModelAttribute EmployeeEntity employeeEntity, Model model) {
        if(employeeEntityDAO.existsById(employeeEntity.getId())) {
            EmployeeEntity newEmp = new EmployeeEntity();
            newEmp.setId(employeeEntity.getId());
            newEmp.setEname(employeeEntity.getEname());
            newEmp.setJob(employeeEntity.getJob());
            newEmp.setDeptno(employeeEntity.getDeptno());
            employeeEntityDAO.save(newEmp);
            model.addAttribute("tipo_operacion", "ok");
            model.addAttribute("message", "Empleado actualizado correctamente");
        }
        else{
            model.addAttribute("tipo_operacion", "error");
            model.addAttribute("message", "Error al actualizar el empleado");
        }
        return "altaempleado";
    }

}
