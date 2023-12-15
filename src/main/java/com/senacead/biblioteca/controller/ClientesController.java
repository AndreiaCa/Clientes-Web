package com.senacead.biblioteca.controller;


import com.senacead.biblioteca.model.empresas;
import com.senacead.biblioteca.model.vendap;
import com.senacead.biblioteca.model.vendedor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientesController {
    
    
    private List<vendap> vendasPerdidas = new ArrayList<>();
     private List<vendedor> idVe = new ArrayList<>();
     private List<empresas> emp = new ArrayList<>();
     
        
    @GetMapping("/") //eh definido a URL que sera chamada
    public String inicio(){
        return "index"; //sera apontado o arquivo HTML que sera chamado
    }
    
     @PostMapping("/processarLogin")
    public String processarLogin(String codigo) {
       
        
        if ("2323".equals(codigo)) {
            return "redirect:/listagem";
        } else {
            return "redirect:/";
        }
    }
    
    @GetMapping("/inserir-livro") //eh definido a URL que sera chamada
    public String cadastroForm(Model model){
        model.addAttribute("empresas", new empresas());
        return "cadastro"; //sera apontado o arquivo HTML que sera chamado
    }  
    
    @GetMapping("/listagem") //eh definido a URL que sera chamada
    public String listaForm(Model model){
        model.addAttribute("lista", emp);
        return "lista"; //sera apontado o arquivo HTML que sera chamado
    } 
    // rota para gravar os dados , serao sera mais get pq esta entrando no servidor
    @PostMapping("/gravar")
    public String processarFormulario(@ModelAttribute empresas empresas, Model model){
        empresas.setId(emp.size() + 1);
        //livro.setLido(false);
        emp.add(empresas);
        return "redirect:/listagem";
    }
    
    //telaRegistro
    //vendap
    @PostMapping("/gravar-comentario")
    public String gravarComentarioUsuario(@ModelAttribute empresas empresas, @ModelAttribute vendap vendap, Model model){
        vendap.setId(vendasPerdidas.size()+1);
        //comentario.setLivro(livro);//venda que esta chegando
        vendap.setE(empresas);
        vendasPerdidas.add(vendap);
        return "redirect:/listagem";
    }    
    
    @GetMapping("/exibir")
    public String mostraDetalhesLivro(Model model, @RequestParam String id){
        Integer idEmp = Integer.parseInt(id);
        
        empresas registroEncontrado = new empresas();
        for(empresas l: emp){
           if(l.getId()==idEmp) {
               registroEncontrado = l;
               break;
           }
        }
        //separado
        vendap comentarioEncontrado = new vendap();
        for (vendap com: vendasPerdidas) {
            if (com.getE().getId()==idEmp) {
                
                comentarioEncontrado = com;
                break;
            }
        }
        
        model.addAttribute("empresas", registroEncontrado);
        model.addAttribute("vendap", comentarioEncontrado);
        return "exibir";
    }
   
}
