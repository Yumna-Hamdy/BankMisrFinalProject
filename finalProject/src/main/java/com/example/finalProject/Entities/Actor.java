import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Actor{
    @Id
    @GeneratedValue
    public int actorId;
    public String actorName;
    // add image absolute path

    @OneToMany(mappedby = )
    //@JoinColumn(name = )

}