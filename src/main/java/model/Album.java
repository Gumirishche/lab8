package model;

import javax.persistence.*;
import java.util.List;

@javax.persistence.SequenceGenerator(name = "SEQ_ID", sequenceName = "SEQ_ID")
@Entity
@Table(name = "albums")
public class Album {
    private Long id;
    private Performer idPerformer;
    private String name;
    private String style;

    public Album() {
    }

    public Album(String name, String style) {
        this.name = name;
        this.style = style;
    }

    private List<Composition> compositions;

    @Id
    @GeneratedValue(generator = "SEQ_ID")
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "id_performer")
    public Performer getIdPerformer() {
        return idPerformer;
    }

    public void setIdPerformer(Performer idPerformer) {
        this.idPerformer = idPerformer;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch =
            FetchType.LAZY)
    public List<Composition> getCompositions() {
        return compositions;
    }

    public void setCompositions(List<Composition> compositions) {
        this.compositions = compositions;
    }
}
