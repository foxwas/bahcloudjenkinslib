package com.abcinc

import java.text.SimpleDateFormat

class simpleClass {
 int square(int a) {
  return a * a; 
 }

 def sayHello(def name) {
  return "Hi, ${name}";
 }

 def getDateTime() {
  def date = new Date()
  def sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
  return sdf.format(date);
 }
}