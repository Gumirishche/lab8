package model;

import javax.persistence.*;
import java.util.List;

@javax.persistence.SequenceGenerator(name = "SEQ_ID", sequenceName = "SEQ_ID")
@Entity
@Table(name = "albums")
public class Album {
    private Long id;
    private Long id_performer;
    private String name;
    private String style;

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

    @Column(name = "id_performer")
    public Long getId_performer() {
        return id_performer;
    }

    public void setId_performer(Long id_performer) {
        this.id_performer = id_performer;
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

    @OneToMany(cascade = CascadeType.ALL, fetch =
            FetchType.LAZY)
    @JoinColumn(name = "id_album", nullable = false)
    public List<Composition> getCompositions() {
        return compositions;
    }

    public void setCompositions(List<Composition> compositions) {
        this.compositions = compositions;
    }
}
