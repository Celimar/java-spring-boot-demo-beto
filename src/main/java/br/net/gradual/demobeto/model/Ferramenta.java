package br.net.gradual.demobeto.model;

import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String name;

    @ManyToOne
    @JoinColumn(name = "finalidadeId", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_ferramenta_01__finalidade"))
    private Finalidade finalidade;

}
