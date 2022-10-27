package com.menu;

import com.menu.domain.Cat;
import com.menu.domain.Dog;
import com.menu.domain.Zookeeper;

public class Application {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Cat cat1 = new Cat(); // Animal 어노테이션이 없을 때
        Zookeeper zookeeper = new Zookeeper();

        zookeeper.greet();
        zookeeper.feed(dog1);
        zookeeper.feed(cat1);
    }
}
