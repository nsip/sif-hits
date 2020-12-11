package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PersonPicture_PublishingPermission")
public class PersonPicturePublishingPermission {
    private Long id;
    private PersonPicture personPicture;
    private String permissionCategory;
    private String permissionValue;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "PersonPicture_RefId", referencedColumnName = "RefId")
    public PersonPicture getPersonPicture() {
        return personPicture;
    }

    public void setPersonPicture(PersonPicture personPicture) {
        this.personPicture = personPicture;
    }

    public String getPermissionCategory() {
        return permissionCategory;
    }

    public void setPermissionCategory(String permissionCategory) {
        this.permissionCategory = permissionCategory;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }
}
