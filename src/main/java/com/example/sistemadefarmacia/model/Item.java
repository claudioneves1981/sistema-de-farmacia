package com.example.sistemadefarmacia.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@SequenceGenerator(name = "seq_codigo" , sequenceName = "seq_codigo", allocationSize = 1)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_codigo")
    private Long codigo;

    private String nome;

    private Integer quantidade;

    private String tipo;



}
