import java.util.ArrayList;
import java.util.Map;

import java.util.HashMap;

import models.Section;
import spark.ModelAndView;

import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

import models.Department;

import models.Section;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port (port);

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
                    String sectionName = request.queryParams("sectionName");
//                    Section section = request.queryParams("section);
                    Department newDepartment = new Department(departmentAbbreviation, departmentName, divisionName, sectionName);
                    newDepartment.getSections().add(sectionName);
                    request.session().attribute("departmentName", departmentName);
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


        get("/department/:id/add", (request, response) -> {
                    Map<String, Object> model = new HashMap<>();
                    int idOfDepartmentToFind = Integer.parseInt(request.params("id"));
                    Department foundDepartment = Department.findById(idOfDepartmentToFind);
                    model.put("department", foundDepartment);
                    return new ModelAndView(model, "sectionForm.hbs");
                }, new HandlebarsTemplateEngine()
        );


        post("/department/:id/add", (request, response) -> {
                    Map<String, Object> model = new HashMap<>();
                    String sectionName = request.queryParams("sectionName");
//                    Section newSection = new Section(sectionName);
                    int idOfDepartmentToFind = Integer.parseInt(request.params("id"));
                    Department foundDepartment = Department.findById(idOfDepartmentToFind);
                    foundDepartment.getSections().add(sectionName);
                    request.session().attribute("sectionName", sectionName);
//                    model.put("section", newSection);
                    response.redirect("/department/" + idOfDepartmentToFind);
                    return null;
                }, new HandlebarsTemplateEngine()
        );

        get("/sections", (request, response) -> {
                    Map<String, Object> model = new HashMap<>();
                    ArrayList<Section> newSection = Section.getAll();
                    model.put("section", newSection);
                    return new ModelAndView(model, "sections.hbs");
                }, new HandlebarsTemplateEngine()
        );



        get("/department/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfDepartmentToFind = Integer.parseInt(request.params("id"));
            Department foundDepartment = Department.findById(idOfDepartmentToFind);
            model.put("department", foundDepartment);
            return new ModelAndView(model, "individualDepartment.hbs");
        }, new HandlebarsTemplateEngine()
        );

        get("/department/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfDepartmentToEdit = Integer.parseInt(request.params("id"));
            Department editDepartment = Department.findById(idOfDepartmentToEdit);
            model.put("editDepartment", editDepartment);
            return new ModelAndView(model, "departmentForm.hbs");
        },new HandlebarsTemplateEngine()
        );

        post("/department/:id/update", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            String newSectionName = request.queryParams("sectionName");
            String newDepartmentAbbreviation = request.queryParams("departmentAbbreviation");
            String newDepartmentName = request.queryParams("departmentName");
            String newDivisionName = request.queryParams("divisionName");
            int idOfDepartmentToEdit = Integer.parseInt(request.params("id"));
            Department editDepartment = Department.findById(idOfDepartmentToEdit);
            editDepartment.update(newDepartmentAbbreviation, newDepartmentName, newDivisionName, newSectionName);
            return new ModelAndView(model, "individualDepartment.hbs");
        }, new HandlebarsTemplateEngine()
        );







    }

}
