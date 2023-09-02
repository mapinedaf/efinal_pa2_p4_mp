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
@Table(name = "estudiante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Estudiante {

    @Id
    @Column(name = "estu_id")
    @GeneratedValue(generator = "sec_estudiante", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_estudiante", sequenceName = "sec_estudiante", allocationSize = 1)
    private Integer id;

    @Column(name = "estu_nombre")
    private String nombre;

    @Column(name = "estu_apellido")
    private  String apellido;

    @Column(name = "estu_cedula")
    private String cedula;

    @Column(name = "estu_direccion")
    private String direccion;

    @Column(name = "estu_telefono")
    private  String telefono;

    @OneToMany(mappedBy = "estudiante")
    private List<Matricula> matriculas;

}
