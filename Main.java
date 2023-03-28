import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner inventorymenu = new Scanner(System.in);
    ArrayList itemarray = new ArrayList<>();
    boolean quit = false;
    while (quit != true) {
      System.out.println("Press 1 to add an item.");

      System.out.println("Press 2 to delete an item.");

      System.out.println("Press 3 to update an item.");

      System.out.println("Press 4 to show all the items.");

      System.out.println("Press 5 to quit the program.");

      int selection = inventorymenu.nextInt();

      if (selection == 1) {
        Scanner additem = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = additem.nextLine(); // Use nextLine() instead of next() because github keeps complaining
        itemarray.add(name);
        System.out.println("Enter the serial number: ");
        String serialnum = additem.next();
        itemarray.add(serialnum);
        System.out.println("Enter the value in dollars (whole number):");
        int value = additem.nextInt();
        itemarray.add(value);
        System.out.println(name + "," + serialnum + "," + value);
        additem.nextLine(); // Consume the newline character
      }

      if (selection == 2) {
        Scanner deleteitem = new Scanner(System.in);
        System.out.println("Enter the serial number of the device to delete: ");
        String serialnum = deleteitem.next();

        // find the index of the element with the given serial number
        int index = -1;
        for (int i = 0; i < itemarray.size(); i += 3) {
          if (itemarray.get(i + 1).equals(serialnum)) {
            index = i;
            break;
          }
        }

        // check if the element was found
        if (index == -1) {
          System.out.println("Device with serial number " + serialnum + " was not found.");
        } else {
          // remove the name, serial number, and value from the list
          itemarray.remove(index);
          itemarray.remove(index);
          itemarray.remove(index);
          System.out.println("Device with serial number " + serialnum + " was deleted.");
        }
      }

 if (selection == 3) {
        Scanner changeitem = new Scanner(System.in);
        System.out.println("Enter the serial number of the device to change: ");
        String serialnum = changeitem.next();

        // find the index of the element with the given serial number
        int index = -1;
        for (int i = 0; i < itemarray.size(); i += 3) {
          if (itemarray.get(i + 1).equals(serialnum)) {
            index = i;
            break;
          }
        }

        // check if the element was found
        if (index == -1) {
          System.out.println("Device with serial number " + serialnum + " was not found.");
        } else {
          // prompt the user for the new values
          System.out.println("Enter the new name: ");
          String name = changeitem.next();
          System.out.println("Enter the new value in dollars (whole number):");
          int value = changeitem.nextInt();

          // create a new item array list with the new values
          ArrayList<String> newItem = new ArrayList<>();
          newItem.add(name);
          newItem.add(serialnum);
          newItem.add(Integer.toString(value));

          // replace the old item with the new one
          itemarray.set(index, newItem);

          System.out.println("Device with serial number " + serialnum + "was updated.");
        }
      }

      if (selection == 4) {
        if (itemarray.isEmpty()) {
          System.out.println("The inventory is currently empty.");
        } else {
          for (Object item : itemarray) {
            ArrayList<String> newItem = (ArrayList<String>) item;
            String name = newItem.get(0);
            String serialnum = newItem.get(1);
            String value = newItem.get(2);
            System.out.println(name + "," + serialnum + "," + value);
          }
        }
      }

      if (selection == 5) {
        System.out.println("You have quit the program. Have a nice day!");
        quit = true;
      }
    }
  }
}
