package com.company;

public class Devices {
  private boolean isOn;
  private String name;

  public Devices(String name, boolean isOn){
    this.isOn = isOn;
    this.name = name;
  }

  public Devices(String name){
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