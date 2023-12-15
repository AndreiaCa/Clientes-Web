
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
@Table(name="vendedor")
public class vendedor {
    @Id
     @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    
    private String nome ; 
    private String telefone ; 
    private String endereco ; 
    private String cidade; 
    private String estado ;
    private String cpf;
    private double salario;
    private String codigo;
    
    
}

