package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    public static boolean search(ArrayList<Integer> array, int e) {
      System.out.println("inside search");
      if (array == null) return false;

      for (int elt : array) {
        if (elt == e) return true;
      }
      return false;
    }
    public static String giveKey(ArrayList<Integer> box1, ArrayList<Integer> box2, ArrayList<String> box3, ArrayList<String> box4){
      String posibility = "";
      int min = box1.size();
      if(box2.size() < min && box2 != null){
        min = box2.size();
      }
      if(box3.size() < min && box3 != null){
        min = box3.size();
      }      
      if(box4.size() < min && box4 != null){
        min = box4.size();
      }  
      for(int i = 0; i < min; i++){  
        int random = 0;
        if(box1 != null){
          random = ((int) (Math.random())) * box1.size();
          posibility += box1.get(random);
        }
        if(box2 != null){
          random = ((int) (Math.random())) * box2.size();
          posibility += box2.get(random);
        }
        if(box3 != null){
          random = ((int) (Math.random())) * box3.size();
          posibility += box3.get(random);
        }
        if(box4 != null){
          random = ((int) (Math.random())) * box4.size();
          posibility += box4.get(random);
        }
        posibility += " ";      
      }
      return posibility;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));
          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
         

         System.out.println(inputList);


          String input2 = req.queryParams("input2").replaceAll("\\s","");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value2 = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value2);
          }
          System.out.println(inputList2);

          String input3 = req.queryParams("input3");
          java.util.Scanner sc3 = new java.util.Scanner(input3);
          sc3.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList3 = new java.util.ArrayList<>();
          while (sc3.hasNext())
          {
            String value3 = sc3.next();
            inputList3.add(value3);
          }
          System.out.println(inputList3);

          String input4 = req.queryParams("input4");
          java.util.Scanner sc4 = new java.util.Scanner(input4);
          sc4.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList4 = new java.util.ArrayList<>();
          while (sc4.hasNext())
          {
            String value4 = sc4.next();
            inputList4.add(value4);
          }
          System.out.println(inputList4);          

          String result = App.giveKey(inputList, inputList2,inputList3,inputList4);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

