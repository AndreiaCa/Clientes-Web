
package com.senacead.biblioteca.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="vendap")
public class vendap {
    
     @Id
     @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
     
     @ManyToOne
    @JoinColumn(name = "emp_id")
    public empresas e ; 
    private String observacao;
     @ManyToOne
    @JoinColumn(name = "idVendendor")
    public vendedor v ; 
    

   
    
}

