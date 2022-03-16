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

  // to be implemented in vol.2
  public String toString(){
    return name + " is on: " + isOn;
  }

  void displayDeviceStatus(){
    System.out.println("Light on? " + isOn);
  }

  public void pushDevice(){
    if(isOn == true){
      isOn = false;
    } else{
      isOn = true;
    }
  }

}
