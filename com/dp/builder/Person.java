package com.dp.builder;

public class Person {
    private String name;
    private String country;
    private int age;

    private Person(PersonBuilder personBuilder){
        this.name = personBuilder.name;
        this.country = personBuilder.country;
        this.age = personBuilder.age;
    }

    public static class PersonBuilder {
        private String name;
        private String country;
        private int age;

        public PersonBuilder name(String name){
            this.name = name;
            return this;
        }
        public PersonBuilder country(String country){
            this.country = country;
            return this;
        }
        public PersonBuilder age(int age){
            this.age = age;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
