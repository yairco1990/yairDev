package dal.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Yair on 08/09/2015.
 */
@Entity
@Table(name = "event", schema = "", catalog = "yairdev")
public class EventEntity {
    private int id;
    private String name;
    private Collection<PictureEntity> picturesById;
    private Collection<UserEntity> usersById;
    private String image;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventEntity that = (EventEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "eventByEventId")
    public Collection<PictureEntity> getPicturesById() {
        return picturesById;
    }

    public void setPicturesById(Collection<PictureEntity> picturesById) {
        this.picturesById = picturesById;
    }

    @OneToMany(mappedBy = "eventByEventId")
    public Collection<UserEntity> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<UserEntity> usersById) {
        this.usersById = usersById;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
