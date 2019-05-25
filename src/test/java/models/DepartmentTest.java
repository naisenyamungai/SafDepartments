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
    }

    @Test
    public void NewDepartmentObjectGetsCorrectlyCreated_true() throws Exception{
        Department department = new Department("NPD", "Network Planning and Design", "Technology");
        assertEquals(true, department instanceof Department);
    }

    @Test
    public void AllDepartmentsAreCorrectlyReturned_true() {
        Department department = new Department("NPD","Network Planning and Design","Technology");
        Department otherDepartment = new Department("CSO","Converged Services Operations","Technology");
        assertEquals(2, Department.getAll().size());
    }

    @Test
    public void AllDepartmentsContainsAllDepartments_true() {
        Department department = new Department("NPD","Network Planning and Design","Technology");
        Department otherDepartment = new Department("CSO","Converged Services Operations","Technology");
        assertTrue(Department.getAll().contains(department));
        assertTrue(Department.getAll().contains(otherDepartment));
    }
}