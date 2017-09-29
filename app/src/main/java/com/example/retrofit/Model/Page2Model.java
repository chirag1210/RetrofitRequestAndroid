package com.example.retrofit.Model;

import java.util.ArrayList;

/**
 * Created by Chirag Chaudhari on 1/13/2017.
 */

public class Page2Model {

   public String getTotal() {
      return total;
   }

   public void setTotal(String total) {
      this.total = total;
   }

   public String getPage() {
      return page;
   }

   public void setPage(String page) {
      this.page = page;
   }

   private String page;
   private String total;

   public ArrayList<DetailDatamodel> data;

}
