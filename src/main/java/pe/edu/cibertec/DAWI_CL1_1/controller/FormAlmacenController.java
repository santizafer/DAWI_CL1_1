package pe.edu.cibertec.DAWI_CL1_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_1.model.AlmacenModel;

@Controller
public class FormAlmacenController {

    @GetMapping("/almacen")
    public String index(Model model) {
        model.addAttribute("verresultado", false);
        model.addAttribute("almacenmodel", new AlmacenModel());
        return "formalmacen";
    }

    @PostMapping("/almacen")
    public String calcularPrecio(
            @ModelAttribute("almacenmodel")
            AlmacenModel almacenModel,
            Model model){

        Double precio = almacenModel.getCantidad() * almacenModel.getPrecio();
        Double preciofinal = 0.0;

        if (almacenModel.getCantidad() > 10 && almacenModel.getCantidad() <= 20) {
            preciofinal = precio - (precio * 0.05);
        }  else if (almacenModel.getCantidad() > 20) {
            preciofinal = precio - (precio * 0.10);
        } else {
            preciofinal = precio;
        }

        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", "El precio a cancelar es : " + String.format("%.2f",preciofinal));
        model.addAttribute("almacenmodel", new AlmacenModel());

        return  "formalmacen";

    }

}
