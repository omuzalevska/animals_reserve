package dev.muzalevska.reservanatural.family;

public class FamilyDTO {
    private Long id;
    private String name;

    public FamilyDTO() {    
    }
    
    public FamilyDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public FamilyDTO(Family family) {
        this.id = family.getId();
        this.name = family.getName();
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
