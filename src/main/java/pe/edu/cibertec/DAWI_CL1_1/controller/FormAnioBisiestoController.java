package pe.edu.cibertec.DAWI_CL1_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_1.model.AnioBisiestoModel;

@Controller
public class FormAnioBisiestoController {

    @GetMapping("/validarbisiesto")
    public String index(Model model) {
        model.addAttribute("verresultado", false);
        model.addAttribute("aniobisiestomodel", new AnioBisiestoModel());
        return "formaniobisiesto";
    }

    @PostMapping("/validarbisiesto")
    public String validarBisiesto(
            @ModelAttribute("aniobisiestomodel")
            AnioBisiestoModel anioBisiestoModel,
            Model model) {
        String resultado = esBisiesto(anioBisiestoModel.getAnio())
            ? "El año " + anioBisiestoModel.getAnio() + " es Bisiesto"
            : "El año " + anioBisiestoModel.getAnio() + " no es Bisiesto";

        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", resultado);
        return "formaniobisiesto";
    }

    private Boolean esBisiesto(Integer numero){
        return (numero % 400 == 0) ? true : (numero % 100 == 0) ? false : numero % 4 == 0;
    }

}
