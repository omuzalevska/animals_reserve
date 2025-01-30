package dev.muzalevska.reservanatural.type;

public class TypeDTO {
    private Long id;
    private String name;
    private Long familyId; 
    //DTO зазвичай містить прості типи даних, такі як Long, String і т. д., 
    //для передачі даних між клієнтом і сервером. Поле familyId повинно зберігати тільки ID сімейства (типу Long)
    
    public TypeDTO() {
    }

    public TypeDTO(Long id, String name, Long familyId) {
        this.id = id;
        this.name = name;
        this.familyId = familyId;
    }

    public TypeDTO(Type type) {
        this.id = type.getId();
        this.name = type.getName();
        this.familyId = type.getFamily().getId(); // Отримуємо ID сімейства
    }

    // Геттери та сеттери
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

}
