package org.example;

public class Drink {
    String name;
    int size;

    public Drink(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public  double getPrice(){
        if(size == 1){
            return 2;
        } else if (size == 2){
            return 2.5;
        } else return 3;

    }

}
