package uk.ac.brunel.cs1702;

import java.util.ArrayList;
import java.util.List;


public class MyStore {

 private List < ItemForSale > items = null;

 public MyStore() {
  this.items = new ArrayList < ItemForSale > ();
 }

 public void setItems(List < ItemForSale > items) {
  this.items = items;
 }

 public void main(String[] args) {

  MyStore myStore = new MyStore();
  myStore.items.add(new ItemForSale("Special cake baked in store", 2, 6));
  myStore.items.add(new ItemForSale("Tickets to Iron Maiden concert", 15, 20));
  myStore.items.add(new ItemForSale("Herbal Health Supplements", 10, 5));
  myStore.items.add(new ItemForSale("Aged Parmesan cheese", 20, 10));
  myStore.items.add(new ItemForSale("Local soda drink", 20, 3));
  myStore.items.add(new ItemForSale("World War I Medals", 0, 80));


  myStore.updateInventory();

  System.out.println("Up to date Inventory ");
  System.out.println("Inventory Updated!");
 }

 //Check to check if we can increase the price so it not over 50
 public boolean ifIncreasePrice(int id, Integer maxPrice) {
  maxPrice = maxPrice != null ? maxPrice : 50;
  if (items.get(id).getPrice() < maxPrice) {
   return true;
  }
  return false;
 }

 //Decreasing price but not be a negative price
 public boolean ifDecreasePrice(int id) {
  if (items.get(id).getPrice() > 0) {
   return true;
  }
  return false;
 }

 //Up to date inventory for a all regular prices
 public void updateInventoryForRegularProduct(int id) {
  if (ifDecreasePrice(id)) {
   items.get(id).setPrice(items.get(id).getPrice() - 1);
  }
  if (items.get(id).getNumberOfDaysToSellIn() < 0) {
   if (ifDecreasePrice(id)) {
    items.get(id).setPrice(items.get(id).getPrice() - 1);
   }
  }
 }

 //up to date inventory for bakery products
 public void updateInventoryForBakeryProducts(int id) {
  updateInventoryForRegularProduct(id);
  updateInventoryForRegularProduct(id);
 }

 //up to date Inventory for aging products
 public void updateInventoryForAgingProducts(int id) {
  if (ifIncreasePrice(id, null)) {
   items.get(id).setPrice(items.get(id).getPrice() + 1);
  }
 }

 //Up to date inventory for tickets
 public void updateInventoryForTickets(int id) {
  if (ifIncreasePrice(id, null)) {
   items.get(id).setPrice(items.get(id).getPrice() + 1);
  }
  if (items.get(id).getNumberOfDaysToSellIn() < 11) {
   if (ifIncreasePrice(id, null)) {
    items.get(id).setPrice(items.get(id).getPrice() + 1);
   }
  }
  if (items.get(id).getNumberOfDaysToSellIn() < 6) {
   if (ifIncreasePrice(id, null)) {
    items.get(id).setPrice(items.get(id).getPrice() + 1);
   }
  }
  if (items.get(id).getNumberOfDaysToSellIn() <= 0) {
   items.get(id).setPrice(0);
  }
 }

 public void updateInventory() {
  for (int i = 0; i < items.size(); i++) {
   //New inventory according to the product category in the shops
   switch (items.get(i).getName()) {
    case "Aged Parmesan cheese":
     updateInventoryForAgingProducts(i);
     break;
    case "Tickets to Iron Maiden concert":
     updateInventoryForTickets(i);
     break;
    case "Special cake baked in store":
     updateInventoryForBakeryProducts(i);
     break;
    case "World War I Medals":
     //Do nothing
     break;
    default:
     updateInventoryForRegularProduct(i);
     break;
   }
   //If the item is for sale, decrease the number of days to sell in
   if (!items.get(i).getName().equals("World War I Medals")) {
    items.get(i).setNumberOfDaysToSellIn(items.get(i).getNumberOfDaysToSellIn() - 1);
   	}
   }
  }
}
   
  
 
