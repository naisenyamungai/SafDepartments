package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Department.clearAllDepartments();
    }

    @Test
    public void NewDepartmentObjectGetsCorrectlyCreated_true() throws Exception{
        Department department = new Department("NPD","Network Planning and Design","Technology", "Network Optimization");
        assertEquals(true, department instanceof Department);
    }


    @Test
    public void AllDepartmentsAreCorrectlyReturned_true() {
        Department department = new Department("NPD","Network Planning and Design","Technology", "Network Optimization");
        Department otherDepartment = new Department("CSO","Converged Services Operations","Technology", "Network Optimization");
        assertEquals(2, Department.getAll().size());
    }

    @Test
    public void AllDepartmentsContainsAllDepartments_true() {
        Department department = new Department("NPD","Network Planning and Design","Technology", "Network Optimization");
        Department otherDepartment = new Department("CSO","Converged Services Operations","Technology", "Network Optimization");
        assertTrue(Department.getAll().contains(department));
        assertTrue(Department.getAll().contains(otherDepartment));
    }

    @Test
    public void getId_departmentInstantiateWithAnID_1() throws Exception {
        Department.clearAllDepartments();
        Department department = new Department("NPD", "Network Planning and Design", "Technology", "Network Optimization");
        assertEquals(1, department.getId());
    }

    @Test
    public void findReturnsCorrectDepartment() throws Exception {
        Department department = new Department("NPD", "Network Planning and Design", "Technology", "Network Optimization");
        assertEquals(1, Department.findById(department.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOneDepartmentExists() throws Exception{
        Department department = new Department("NPD", "Network Planning and Design", "Technology", "Network Optimization");
        Department otherDepartment = new Department("CSO", "Converged Service Operations", "Technology", "Network Optimization");
        assertEquals(2, Department.findById(otherDepartment.getId()).getId());
    }

    public Department setupNewDepartment(){
        return new Department("NPD", "Network Planning and Design", "Technology", "Network Optimization");
    }

    @Test
    public void updateChangesDepartmentContent() throws Exception{
        Department department = new Department("NPD", "Network Planning and Design", "Technology", "Network Optimization");
        String formerSection = department.getSection();
        int formerId = department.getId();

        department.update("NPD", "Network Planning and Design", "Technology","Radio Access Network");

        assertEquals(formerId, department.getId());
        assertNotEquals(formerSection, department.getSection());
    }
}