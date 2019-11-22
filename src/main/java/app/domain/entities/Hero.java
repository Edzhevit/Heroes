package app.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {

    private String name;
    private String classOption;
    private Integer level;

    public Hero() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getClassOption() {
        return classOption;
    }

    public void setClassOption(String classOption) {
        this.classOption = classOption;
    }

    @Column(nullable = false)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
