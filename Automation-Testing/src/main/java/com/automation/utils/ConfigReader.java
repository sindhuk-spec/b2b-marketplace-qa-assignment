package com.automation.utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public final class ConfigReader {
 private static final Properties CONFIG=new Properties(), TESTDATA=new Properties();
 static { load("config.properties",CONFIG); load("testdata.properties",TESTDATA); }
 private ConfigReader(){}
 private static void load(String name,Properties target){
  try(InputStream in=ConfigReader.class.getClassLoader().getResourceAsStream(name)){
   if(in==null) throw new IllegalStateException(name+" not found in src/main/resources");
   target.load(in);
  }catch(IOException e){throw new RuntimeException("Unable to load "+name,e);}
 }
 public static String get(String key){return required(CONFIG,key);}
 public static String getTestData(String key){return required(TESTDATA,key);}
 public static int getInt(String key){return Integer.parseInt(get(key));}
 private static String required(Properties p,String key){
  String v=p.getProperty(key); if(v==null||v.isBlank()) throw new IllegalArgumentException("Missing property: "+key); return v.trim();
 }
}
