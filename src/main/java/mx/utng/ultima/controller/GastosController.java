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
import mx.utng.ultima.model.entity.Gastos;
import mx.utng.ultima.model.service.IGastosService;



@Controller
@SessionAttributes("gastos")
public class GastosController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IGastosService gastosService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/gastos/list","/gastos","/gastos/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de registro de gastos");
    model.addAttribute("gastoss", gastosService.list());
    return "glist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/gastos/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de registro de gastos");
        model.addAttribute("gastos", new Gastos());
        return "gform";
    }

    @GetMapping("/gastos/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Gastos gastos = null;
        if (id>0) {
            gastos = gastosService.getById(id);
        }else{
            return "redirect:glist";
        }

        model.addAttribute("title", "Editar Gastos");
        model.addAttribute("gastos", gastos);
        return "gform";
    }

    @PostMapping ("/gastos/form")
    public String save(@Valid Gastos gastos, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Gastos");
            return "gform";
        }

        gastosService.save(gastos);
        return "redirect:/gastos/list";
    }

    @GetMapping("/gastos/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            gastosService.delete(id);
        }
        return "redirect:/gastos/list";
    }

}



