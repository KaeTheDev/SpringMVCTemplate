package com.test.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.sql.*;
import java.util.ArrayList;


@Controller
public class HomeController
{

    @RequestMapping("/")

    public ModelAndView helloWorld()
    {
        return new
                ModelAndView("welcome","message","Hello World");

    }

    @RequestMapping(value="getAllCustomers")
    public ModelAndView getAllCustomers ()
    {
        String dbAddress = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "Godswill17";



            try {
                //Load Driver
                Class.forName("com.mysql.jdbc.Driver");
                //DriverManager.registerDriver(new com.mysql.jdbc.Driver());

                //create the db connection object
                Connection mysqlConnection;
                mysqlConnection = DriverManager.getConnection(dbAddress, username, password);

                //create the db statement
                String readCustomersCommand = "select customerid, companyname, city from customers";

                //Creates the statement
                Statement readCustomers = mysqlConnection.createStatement();

                //Executes the statement
                readCustomers.executeQuery(readCustomersCommand);

                //Executes the statement
                ResultSet results = readCustomers.executeQuery(readCustomersCommand);

                //arraylist of customers
                ArrayList<Customer> customerList = new ArrayList<Customer>();

                //Map from the ResultSet to the ArrayList
                while (results.next())
                {
                    Customer temp = new Customer(results.getString(1), results.getString(2), results.getString(3));
                    customerList.add(temp);
                }

                return new ModelAndView("customerView","cList",customerList);
            }
            catch (Exception ex)
            {

            }
            return null; //todo: create an error page with custom error messages
        }



    @RequestMapping ("/userform")
    public ModelAndView userfom()
    {
        return new ModelAndView("form", "inst", "Please enter info: ");
    }

    @RequestMapping("/formhandler")
            public ModelAndView formhandler (@RequestParam("firstname")String firstname,
                                             @RequestParam("lastname") String lastname,
                                             @RequestParam("phonenumber") long phonenumber,
                                             @RequestParam("password") String password,
                                             @RequestParam("email")String email)
            //Server Side Validation


    {
        ModelAndView mv = new ModelAndView("formresponse");
        mv.addObject("firstname", firstname);
        mv.addObject("lastname", lastname);
        mv.addObject("phonenumber", phonenumber);
        mv.addObject("email", email);
        mv.addObject("password", password);
        return mv;
    }


}