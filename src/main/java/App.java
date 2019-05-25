import java.util.ArrayList;
import java.util.Map;

import java.util.HashMap;

import spark.ModelAndView;

import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

import models.Department;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
                    Map<String, Object> model = new HashMap<>();
                    return new ModelAndView(model, "index.hbs");
                }, new HandlebarsTemplateEngine()
        );

        get("/departmentForm", (request, response) -> {
                    Map<String, Object> model = new HashMap<>();
                    return new ModelAndView(model, "departmentForm.hbs");
                }, new HandlebarsTemplateEngine()
        );

        //post: process new Department form
        post("/departmentCreated", (request, response) -> {
                    Map<String, Object> model = new HashMap<>();
                    String departmentName = request.queryParams("departmentName");
                    String divisionName = request.queryParams("divisionName");
                    String departmentAbbreviation = request.queryParams("departmentAbbreviation");
                    Department newDepartment = new Department(departmentAbbreviation, departmentName, divisionName);
//            request.session().attribute("departmentName", departmentName);
                    model.put("department", newDepartment);
                    return new ModelAndView(model, "departmentCreated.hbs");
                }, new HandlebarsTemplateEngine()
        );


        //get: show all departments
        get("/departments", (request, response) -> {
                    Map<String, Object> model = new HashMap<>();
                    ArrayList<Department> newDepartment = Department.getAll();
                    model.put("department", newDepartment);
                    return new ModelAndView(model, "departments.hbs");
                }, new HandlebarsTemplateEngine()
        );

    }

}
