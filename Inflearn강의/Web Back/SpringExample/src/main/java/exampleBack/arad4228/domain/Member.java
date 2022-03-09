package exampleBack.arad4228.domain;

import javax.persistence.*;

@Entity
public class Member {

    // Db가 알아서 생성일시 identity.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
