package com.uce.efinal2_pa2_p4_mp.repository.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Matricula {

    @Id
    @Column(name = "mtcl_id")
    @GeneratedValue(generator = "sec_matricula", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_matricula", sequenceName = "sec_matricula", allocationSize = 1)
    private Integer id;


    @Column(name = "mtcl_fecha")
    private LocalDate fecha;

    @Column(name = "mtcl_nombre_hilo")
    private String nombreHilo;


    @JoinColumn(name = "mtcl_id_estudiante")
    @ManyToOne(fetch = FetchType.EAGER)
    Estudiante estudiante;

    @JoinColumn(name = "mtcl_id_materia")
    @ManyToOne(fetch = FetchType.EAGER)
    Materia materia;
}
