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
import mx.utng.ultima.model.entity.Compra;
import mx.utng.ultima.model.service.ICompraService;



@Controller
@SessionAttributes("compra")
public class CompraController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private ICompraService compraService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/compra/list","/compra","/compra/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Registro de compras de ropa");
    model.addAttribute("compras", compraService.list());
    return "clist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/compra/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Registro de compras");
        model.addAttribute("compra", new Compra());
        return "cform";
    }

    @GetMapping("/compra/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Compra compra = null;
        if (id>0) {
            compra = compraService.getById(id);
        }else{
            return "redirect:clist";
        }

        model.addAttribute("title", "Editar registro de compras");
        model.addAttribute("compra", compra);
        return "cform";
    }

    @PostMapping ("/compra/form")
    public String save(@Valid Compra compra, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de registro de compras");
            return "cform";
        }

        compraService.save(compra);
        return "redirect:/compra/list";
    }

    @GetMapping("/compra/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            compraService.delete(id);
        }
        return "redirect:/compra/list";
    }

}



