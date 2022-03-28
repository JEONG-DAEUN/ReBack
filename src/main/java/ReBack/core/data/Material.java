package ReBack.core.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material")
@Data
public class Material {
    @Id
    @Column(name = "material_code")
    public String materialCode;
    @Column(name = "material_name")
    public String materialName;

    public Material(){

    }
}
