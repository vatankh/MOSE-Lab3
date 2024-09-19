import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@ManagedBean
@ApplicationScoped
public class AltAltPointDateBean implements Serializable {

    UUID owner = UUID.randomUUID();

    private final AltConnectToDB oracle_db = new AltConnectToDB();

    private AltPoint newAltPoint;

    public List<AltPoint> getAltPointsTable(){
        return oracle_db.getAltPoints(this.owner.toString());
    }

    public AltAltPointDateBean() {
        this.newAltPoint = new AltPoint();
    }

    public void setLastR(){
        if(getAltPointsTable().size() != 0)
            newAltPoint.setR(getAltPointsTable().get(0).getR());
    }

    public void doCode(){
        System.out.println("x-> "+newAltPoint.getX());
        newAltPoint.setOwner(owner.toString());
        newAltPoint.check();
        System.out.println("this is the point -> "+newAltPoint.getX());
        oracle_db.addAltPointToTable(newAltPoint);
        newAltPoint = new AltPoint();
        setLastR();
    }

    public void setNewAltPoint(AltPoint newAltPoint) {
        this.newAltPoint = newAltPoint;
    }

    public AltPoint getNewAltPoint() {
        return newAltPoint;
    }

}
