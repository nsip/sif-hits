package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "NAPTestItem_SubstituteItem")
public class SubstituteItem {

    private Integer id;
    private NAPTestItem napTestItem;
    private NAPTestItem substituteItem;
    private Set<String> pnpCodeList;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "NAPTestItem_RefId", referencedColumnName = "RefId")
    public NAPTestItem getNapTestItem() {
        return napTestItem;
    }

    public void setNapTestItem(NAPTestItem napTestItem) {
        this.napTestItem = napTestItem;
    }

    @ManyToOne
    @JoinColumn(name = "SubstituteItem_RefId", referencedColumnName = "RefId")
    public NAPTestItem getSubstituteItem() {
        return substituteItem;
    }

    public void setSubstituteItem(NAPTestItem substituteItem) {
        this.substituteItem = substituteItem;
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "ItemSubstitutedFor_PNPCode", joinColumns = @JoinColumn(name = "ItemSubstitutedFor_Id"))
    @Column(name = "Code")
    public Set<String> getPNPCodeList() {
        return pnpCodeList;
    }

    public void setPNPCodeList(Set<String> pnpCodeList) {
        this.pnpCodeList = pnpCodeList;
    }

}
