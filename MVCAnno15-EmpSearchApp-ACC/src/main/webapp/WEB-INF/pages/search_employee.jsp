<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <h1 style="color: red;text-align: center">Search Employee Details</h1>
    <form action="search_employee.htm" method="POST">
    Employee Number::<input type="text" name="empno" value="0"/><br>
    Employee Name::<input type="text" name="ename"/><br>
    Employee Job::<input type="text" name="job"/><br>
     Employee Salary::<input type="text" name="sal" value="0"/><br>
     <input type="submit" value="Search Employee">
        </form>
