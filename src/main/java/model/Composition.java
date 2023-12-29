package model;

import javax.persistence.*;

@javax.persistence.SequenceGenerator(name = "SEQ_ID", sequenceName = "SEQ_ID")
@Entity
@Table(name = "compositions")
public class Composition {
    private Long id;

    private Long id_album;

    private String name_com;

    private int length;

    @Id
    @GeneratedValue(generator = "SEQ_ID")
    @Column(name = "id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "id_album")
    public Long getIdAlbum() {
        return id_album;
    }
    public void setIdAlbum(Long id_album) {
        this.id_album = id_album;
    }

    @Column(name = "name_com")
    public String getName() {
        return name_com;
    }
    public void setName(String name_com) {
        this.name_com = name_com;
    }

    @Column(name = "id_album")
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
}
