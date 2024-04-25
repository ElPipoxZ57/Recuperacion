package mx.utng.ultima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.ultima.model.entity.Deseos;
import mx.utng.ultima.model.service.IDeseosService;



@Controller
@SessionAttributes("deseos")
public class DeseosController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IDeseosService deseosService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/deseos/list","/deseos","/deseos/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Deseos de moda");
    model.addAttribute("deseoss", deseosService.list());
    return "dlist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/deseos/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Deseos de moda");
        model.addAttribute("deseos", new Deseos());
        return "dform";
    }

    @GetMapping("/deseos/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Deseos deseos = null;
        if (id>0) {
            deseos = deseosService.getById(id);
        }else{
            return "redirect:dlist";
        }

        model.addAttribute("title", "Editar deseos de moda");
        model.addAttribute("deseos", deseos);
        return "dform";
    }

    @PostMapping ("/deseos/form")
    public String save(@Valid Deseos deseos, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de deseos");
            return "dform";
        }

        deseosService.save(deseos);
        return "redirect:/deseos/list";
    }

    @GetMapping("/deseos/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            deseosService.delete(id);
        }
        return "redirect:/deseos/list";
    }
}



