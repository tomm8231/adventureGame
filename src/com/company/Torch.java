package com.company;

public class Torch {
  private boolean isOn;
  private String name;

  public Torch(String name, boolean isOn){
    this.isOn = isOn;
    this.name = name;
  }

  public Torch(String name){
    this.name = name;
  }

  public String toString(){
    return name + " is on: " + isOn;
  }


  public void pushDevice(){
    if(isOn == true){
      isOn = false;
    } else{
      isOn = true;
    }
  }

}
