package com.example;

import java.util.EnumMap;

public class MyClass {
      public static void main(String[] args) {
          System.out.println(ConstantsE.Constants_A.getDescription());  //输出：我是枚举类型A
          System.out.println(ConstantsE.Constants_A);

          for(ConstantsE s: ConstantsE.values()) {
              System.out.println(s + "_" + s.getDescription());
          }

          System.out.println(ConstantsE.Constants_A.getB());

      }
}
