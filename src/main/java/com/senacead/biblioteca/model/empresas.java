
package com.senacead.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="empresas")
public class empresas {
   
    @Id
     @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    
    private String nome; 
    private String cnpj; 
    private String cidade ;
    private String estado;
    private String telefone; 

  
    
}


    

