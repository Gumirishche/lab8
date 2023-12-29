package model;

import javax.persistence.*;
import java.util.List;

@javax.persistence.SequenceGenerator(name = "SEQ_ID", sequenceName = "SEQ_ID")
@Entity
@Table(name = "performers")
public class Performer {
    private Long id;
    private String name;
    private List<Album> albums;

    public Performer() {
    }

    public Performer(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(generator = "SEQ_ID")
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch =
            FetchType.LAZY)
    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
