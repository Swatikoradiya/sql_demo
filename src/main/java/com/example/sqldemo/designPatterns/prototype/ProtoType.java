package com.example.sqldemo.designPatterns.prototype;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ProtoType implements Cloneable {

    int id;
    String name;


    @Override
    public ProtoType clone() {
        try {
            ProtoType clone = (ProtoType) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
