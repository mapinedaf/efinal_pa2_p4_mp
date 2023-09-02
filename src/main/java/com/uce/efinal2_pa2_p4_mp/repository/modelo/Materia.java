package com.uce.efinal2_pa2_p4_mp.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "materia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Materia {

    @Id
    @Column(name = "mate_id")
    @GeneratedValue(generator = "sec_materia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_materia", sequenceName = "sec_materia", allocationSize = 1)
    private Integer id;

    @Column(name = "mate_codigo")
    private String codigo;

    @Column(name = "mate_nombre")
    private String nombre;
    @Column(name = "mate_num_creditos")
    private Integer numCreditos;
    @Column(name = "mate_cedula_profesor")
    private String cedulaProfesor;

    @OneToMany(mappedBy = "materia")
    private List<Matricula> matriculas;

}
