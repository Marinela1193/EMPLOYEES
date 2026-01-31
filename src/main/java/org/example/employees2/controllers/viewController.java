package org.example.employees2.controllers;

import org.example.employees2.models.dao.DeptEntityDAO;
import org.example.employees2.models.entities.DeptEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
class viewController {

    private final DeptEntityDAO deptEntityDAO;

    viewController(DeptEntityDAO deptEntityDAO) {
        this.deptEntityDAO = deptEntityDAO;
    }

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/verdepartamentos")
    public String verdepartamentos(Model model) {
        List<DeptEntity> departs = (List<DeptEntity>) DeptEntityDAO.findAll();
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
}
