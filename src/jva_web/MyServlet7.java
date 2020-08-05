package jva_web;

import jva.TblEmpEntity;
import jva_sesB.MySession7Bean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "MyServlet7", urlPatterns = "/")
public class MyServlet7 extends HttpServlet {
    @EJB
    private MySession7Bean s7;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter ot = response.getWriter();
        response.setContentType("text/html");
        //simple text print from ejb
        ot.println("hello bkakak");
        ot.println(s7.sayHello() + "yes it is printed");
//display searched data based on some criteria
       /*ot.println("<ul>");
        for(TblEmpEntity emp: this.s7.findByName("ebe")){
        ot.println("<li>"+ emp.geteName() +"-"+emp.geteAge()+"</li>");
        }
       ot.println("</ul>");*/
//insert single
       /* TblEmpEntity emp1=new TblEmpEntity();
        emp1.seteName("tt");
        emp1.seteAge(33);
        try {
            this.s7.addEmp(emp1);
            ot.println("inserted successfully");
        }
        finally {
            ot.println("succesfully added");
        }*/
        //update single ...
        /*ot.println("\nupdate statment");
        try {
            this.s7.updateEmp(22,"bruk");
            ot.println("inserted successfully");
        }
        finally {
            ot.println("succesfully added");
        }*/

        //search
        //TblEmpEntity emp2=new TblEmpEntity();
        //ot.println(this.s7.display(emp1,44));

        //delete single
        /*try {
            this.s7.deleteEmp(3);
            ot.println("deleted");
        }
        finally {
            ot.println("....");
        }*/
        //display all
        ot.println("\n....good to display all...\n");
        //ot.println(this.s7.dispAll());
        ot.println("<ul>");
        for (TblEmpEntity emp2 : this.s7.dispAll()) {
            ot.println("<li>" + emp2.geteName() + "-" + emp2.geteAge() + "</li>");
        }
        ot.println("</ul>");
        //search by name
        ot.println("\n search by name...");
        ot.println("<ul>");
        for (TblEmpEntity emp : this.s7.searchData("bruk")) {
            ot.println("<li>" + emp.geteName() + "-" + emp.geteAge() + "-" + emp.geteId() + "</li>");
        }
        ot.println("</ul>");
        //delete many
        ot.println("delete many....");
        try {
            ot.println("this no of rows deleted=...." + this.s7.deleteMany2(6));

        } finally {
            ot.println("....");
        }
        //update many
        ot.println("update many....");
        try {
            ot.println("this no of rows updated=...." + this.s7.UpdateMany("baba",90));
        }
        finally {
            ot.println("....");
        }
    }
}
