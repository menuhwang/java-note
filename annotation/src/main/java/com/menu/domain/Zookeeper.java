package com.menu.domain;

import com.menu.annotation.Animal;
import com.menu.annotation.Person;

@Person(name = "김사육") // 그저 주석의 역할만 하는 중.
public class Zookeeper {
    public void greet() {
        System.out.println("반가워요. 친구들~");
    }
    public void feed(Object o) {
        Animal animal = o.getClass().getAnnotation(Animal.class);
        if (animal != null) {
            System.out.println(animal.name() + "에게 " + animal.feed() + "지급");
        }
    }
}
