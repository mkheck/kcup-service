package com.thehecklers.kcupservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Coffee {
    @Id
    private String id;
    private String type, code;

    public Coffee(String type) {
        this.type = type;
        setCode(type);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String type) {
        this.code = type.toLowerCase().replaceAll(" ", "-");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return id.equals(coffee.id) &&
                type.equals(coffee.type) &&
                code.equals(coffee.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, code);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
