package org.example.employees2.controllers;

import org.example.employees2.models.dao.DeptEntityDAO;
import org.example.employees2.models.entities.DeptEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
class viewController {

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
}
