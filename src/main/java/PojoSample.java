import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public class PojoSample {

    private String name ;
    private String empId ;
    private String orgName ;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PojoSample that = (PojoSample) o;
        return Objects.equals(name, that.name) && Objects.equals(empId, that.empId) && Objects.equals(orgName, that.orgName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, empId, orgName);
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getName() {
        return name;
    }


    public static void main(String args []){
        PojoSample ps = new
                PojoSample();
        StringBuilder name1 = new StringBuilder("sarath");
        StringBuilder name2 = new StringBuilder("sarath");
        System.out.println(name1.equals(name2));
    }

   }
