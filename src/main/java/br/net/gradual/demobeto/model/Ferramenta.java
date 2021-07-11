package br.net.gradual.demobeto.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.sql.Insert;
import org.omg.PortableInterceptor.INACTIVE;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "FERRAMENTA_01")
public class Ferramenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 200)
    private String name;

    @Column(length = 300)
    private String destination;

}
