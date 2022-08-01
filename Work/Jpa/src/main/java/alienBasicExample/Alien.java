package alienBasicExample;

import javax.persistence.*;

@Entity
@Table(name="alien_table")
public class Alien {
    @Id
    private int aid;
    // @Transient --> not stored in db
    private AlienName aname;
    private String color;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AlienName getAname() {
        return aname;
    }

    public void setAname(AlienName aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "alienBasicExample.Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
