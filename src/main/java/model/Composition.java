package model;

import javax.persistence.*;

@javax.persistence.SequenceGenerator(name = "SEQ_ID", sequenceName = "SEQ_ID")
@Entity
@Table(name = "compositions")
public class Composition {
    private Long id;

    private Album idAlbum;

    private String name_com;

    private int length;


    public Composition() {
    }

    public Composition(String name_com, int length) {
        this.name_com = name_com;
        this.length = length;
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

    @ManyToOne
    @JoinColumn(name = "id_album")
    public Album getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Album idAlbum) {
        this.idAlbum = idAlbum;
    }

    @Column(name = "name_com")
    public String getName() {
        return name_com;
    }

    public void setName(String name_com) {
        this.name_com = name_com;
    }

    @Column(name = "length")
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
