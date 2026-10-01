// ============================================================================
// Lab Sheet-05 : Object Oriented Programming Using Java (MCA III Semester)
// Name: Shradha Chauhan | Roll No: 25308078
//
// NOTE: Java allows only ONE public class per .java file, and many questions
// reuse class names (Student, Patient, Medicine...). So this combined file has
// 20 programs, each starting at a "FILE:" marker. Save each section as its own
// file (e.g. StudentMain.java) to compile it. Run split_programs.py (included)
// to do that automatically.
// ============================================================================

// ===== FILE: StudentMain.java =====
// Q1. Student Record - Class and Object
class Student {
    // Instance variables: each object has its own copy
    String name;
    int rollNo;
    double marks;

    // No-argument constructor with suitable default values
    Student() {
        name = "Shradha";
        rollNo = 101;
        marks = 85.5;
    }

    // Display logic lives in the class, not in main()
    void displayDetails() {
        System.out.println("Name   : " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks  : " + marks);
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Student s = new Student(); // object creation
        s.displayDetails();
    }
}

// ===== FILE: MedicineMain.java =====
// Q2. Medicine - Parameterized Constructor and this
class Medicine {
    String medicineName;
    String batchNo;
    double price;

    // Parameterized constructor; parameter names equal field names
    Medicine(String medicineName, String batchNo, double price) {
        this.medicineName = medicineName; // 'this' refers to the current object
        this.batchNo = batchNo;
        this.price = price;
    }

    void displayMedicine() {
        System.out.println("Medicine: " + medicineName + " | Batch: " + batchNo + " | Price: " + price);
    }
}

public class MedicineMain {
    public static void main(String[] args) {
        Medicine m1 = new Medicine("Paracetamol", "B101", 25.50);
        Medicine m2 = new Medicine("Amoxicillin", "B202", 80.00);
        m1.displayMedicine();
        m2.displayMedicine();
    }
}

// ===== FILE: PharmacyMain.java =====
// Q3. Pharmacy - Instance and Class Variables
class Pharmacy {
    String pharmacyName;   // instance variable
    String location;       // instance variable
    static int pharmacyCount = 0; // class variable shared by all objects

    Pharmacy(String pharmacyName, String location) {
        this.pharmacyName = pharmacyName;
        this.location = location;
        pharmacyCount++; // incremented for every object created
    }

    void displayPharmacy() {
        System.out.println("Pharmacy: " + pharmacyName + " | Location: " + location);
    }

    static void displayPharmacyCount() { // static method works on class variable
        System.out.println("Total pharmacies: " + pharmacyCount);
    }
}

public class PharmacyMain {
    public static void main(String[] args) {
        Pharmacy p1 = new Pharmacy("Apollo", "Roorkee");
        Pharmacy p2 = new Pharmacy("MedPlus", "Haridwar");
        Pharmacy p3 = new Pharmacy("Wellness", "Dehradun");
        p1.displayPharmacy();
        p2.displayPharmacy();
        p3.displayPharmacy();
        Pharmacy.displayPharmacyCount();
    }
}

// ===== FILE: PatientMain.java =====
// Q4. Patient Records - Object Array, Loop and Local Variable
class Patient {
    int patientId;
    String patientName;
    int age;

    Patient(int patientId, String patientName, int age) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
    }

    void displayPatient() {
        System.out.println("ID: " + patientId + " | Name: " + patientName + " | Age: " + age);
    }
}

class PatientManager {
    // Processing class: loop is here, not in main()
    void displayAllPatients(Patient[] patients) {
        for (int i = 0; i < patients.length; i++) { // local loop variable i
            patients[i].displayPatient();
        }
    }
}

public class PatientMain {
    public static void main(String[] args) {
        // Object array of five Patient objects
        Patient[] patients = {
            new Patient(1, "Amit", 30),
            new Patient(2, "Neha", 25),
            new Patient(3, "Rahul", 40),
            new Patient(4, "Pooja", 35),
            new Patient(5, "Karan", 50)
        };
        PatientManager manager = new PatientManager();
        manager.displayAllPatients(patients);
    }
}

// ===== FILE: EligibilityMain.java =====
// Q5. Medicine Eligibility - Method and Local Variable
class Medicine {
    String medicineName;
    int ageLimit;

    Medicine(String medicineName, int ageLimit) {
        this.medicineName = medicineName;
        this.ageLimit = ageLimit;
    }

    // Method that returns a result
    String checkEligibility(int patientAge) {
        String result; // local variable
        if (patientAge >= ageLimit) {
            result = "Eligible";
        } else {
            result = "Not Eligible";
        }
        return result;
    }
}

public class EligibilityMain {
    public static void main(String[] args) {
        Medicine m = new Medicine("Cough Syrup", 12);
        System.out.println("Age 15: " + m.checkEligibility(15));
        System.out.println("Age 8 : " + m.checkEligibility(8));
    }
}

// ===== FILE: MedicineProductMain.java =====
// Q6. Encapsulated Medicine Product
class MedicineProduct {
    // Private data: hidden from outside classes (encapsulation)
    private String medicineName;
    private String batchNo;
    private double price;

    MedicineProduct(String medicineName, String batchNo, double price) {
        this.medicineName = medicineName;
        this.batchNo = batchNo;
        this.price = price;
    }

    // Public getters
    public String getMedicineName() { return medicineName; }
    public String getBatchNo() { return batchNo; }
    public double getPrice() { return price; }

    // Public setters
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }
    public void setBatchNo(String batchNo) { this.batchNo = batchNo; }
    public void setPrice(double price) { this.price = price; }

    void displayProduct() {
        System.out.println("Product: " + medicineName + " | Batch: " + batchNo + " | Price: " + price);
    }
}

public class MedicineProductMain {
    public static void main(String[] args) {
        MedicineProduct p = new MedicineProduct("Ibuprofen", "B303", 45.0);
        p.displayProduct();
        p.setPrice(50.0);                       // update through setter
        System.out.println("Updated price: " + p.getPrice()); // read through getter
        p.displayProduct();
    }
}

// ===== FILE: PatientMain.java (Q7) =====
// Q7. Encapsulated Patient - Validation
// (Save this as PatientMain.java in a separate folder from Q4)
class Patient {
    private String patientName;
    private int age;
    private double weight;

    Patient(String patientName, int age, double weight) {
        this.patientName = patientName;
        this.age = age;
        this.weight = weight;
    }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age >= 0) {            // validation: accept only non-negative age
            this.age = age;
        } else {
            System.out.println("Invalid age rejected: " + age);
        }
    }

    public double getWeight() { return weight; }
    public void setWeight(double weight) {
        if (weight > 0) {          // validation: accept only positive weight
            this.weight = weight;
        } else {
            System.out.println("Invalid weight rejected: " + weight);
        }
    }

    void displayPatient() {
        System.out.println("Patient: " + patientName + " | Age: " + age + " | Weight: " + weight);
    }
}

public class PatientMain {
    public static void main(String[] args) {
        Patient p = new Patient("Amit", 30, 65.0);
        p.displayPatient();
        p.setAge(32);       // valid
        p.setWeight(68.5);  // valid
        p.setAge(-5);       // invalid
        p.setWeight(0);     // invalid
        p.displayPatient();
    }
}

// ===== FILE: BankAccountMain.java =====
// Q8. Bank Account - Encapsulation, this and Local Variable
class BankAccount {
    private String accountNo;
    private String accountHolderName;
    private double balance;

    BankAccount(String accountNo, String accountHolderName, double balance) {
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        boolean success; // local variable
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            success = true;
        } else {
            success = false; // fails when amount is greater than balance
        }
        if (success) {
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal failed (insufficient balance or invalid amount): " + amount);
        }
    }

    double getBalance() { return balance; }

    void displayAccount() {
        System.out.println("Account No: " + accountNo + " | Holder: " + accountHolderName + " | Balance: " + getBalance());
    }
}

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("AC1001", "Shradha Chauhan", 5000);
        acc.deposit(2000);
        acc.withdraw(1500);
        acc.withdraw(10000); // should fail
        acc.displayAccount();
    }
}

// ===== FILE: PublicAccessMain.java =====
// Q9. Public Access Specifier
class Hospital {
    // public members: accessible from any class
    public String hospitalName;
    public String hospitalCode;

    public Hospital() {
        hospitalName = "City Hospital";
        hospitalCode = "CH01";
    }

    public void displayHospital() {
        System.out.println("Hospital: " + hospitalName + " | Code: " + hospitalCode);
    }
}

public class PublicAccessMain {
    public static void main(String[] args) {
        Hospital h = new Hospital();
        // Direct access is allowed because the members are public
        System.out.println("Name: " + h.hospitalName);
        System.out.println("Code: " + h.hospitalCode);
        h.displayHospital();
    }
}

// ===== FILE: PrivateAccessMain.java =====
// Q10. Private Access Specifier
class Employee {
    private int employeeId;
    private String employeeName;
    private double salary;

    Employee(int employeeId, String employeeName, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    public int getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public double getSalary() { return salary; }

    public void displayEmployee() {
        System.out.println("ID: " + employeeId + " | Name: " + employeeName + " | Salary: " + salary);
    }
}

public class PrivateAccessMain {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Ravi", 40000);
        // System.out.println(employee.salary); // ERROR: salary is private, direct access not allowed
        System.out.println("ID: " + employee.getEmployeeId());
        System.out.println("Name: " + employee.getEmployeeName());
        System.out.println("Salary: " + employee.getSalary());
        employee.displayEmployee();
    }
}

// ===== FILE: DefaultAccessMain.java =====
// Q11. Default Access Specifier
class Pharmacy {
    String medicineName; // default / package-private variable
    double price;        // default / package-private variable

    Pharmacy() { // default / package-private constructor
        medicineName = "Cetirizine";
        price = 30.0;
    }

    void displayMedicine() { // default / package-private method
        System.out.println("Medicine: " + medicineName + " | Price: " + price);
    }
}

public class DefaultAccessMain {
    public static void main(String[] args) {
        Pharmacy p = new Pharmacy();
        // Direct access works: same package, so default access is allowed
        System.out.println("Direct access -> " + p.medicineName + " : " + p.price);
        p.displayMedicine();
    }
}

// ===== FILE: ProtectedAccessMain.java =====
// Q12. Protected Access Specifier
class HospitalStaff { // super class
    protected int staffId;       // protected: visible in subclasses
    protected String staffName;

    protected HospitalStaff(int staffId, String staffName) {
        this.staffId = staffId;
        this.staffName = staffName;
    }

    protected void displayStaff() {
        System.out.println("Staff ID: " + staffId + " | Name: " + staffName);
    }
}

class Pharmacist extends HospitalStaff { // child class
    private String licenseNo;

    Pharmacist(int staffId, String staffName, String licenseNo) {
        super(staffId, staffName); // initialize parent part
        this.licenseNo = licenseNo;
    }

    void showPharmacistDetails() {
        // Inherited protected members used directly
        System.out.println("Inherited -> ID: " + staffId + ", Name: " + staffName);
        System.out.println("License No: " + licenseNo);
        displayStaff();
    }
}

public class ProtectedAccessMain {
    public static void main(String[] args) {
        Pharmacist ph = new Pharmacist(11, "Sneha", "LIC-7788");
        ph.showPharmacistDetails();
    }
}

// ===== FILE: SingleInheritanceMain.java =====
// Q13. Single Inheritance - Employee -> Pharmacist
class Employee { // SUPER CLASS
    protected int employeeId;
    protected String employeeName;
    protected double salary;

    Employee(int employeeId, String employeeName, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    void displayEmployee() {
        System.out.println("ID: " + employeeId + " | Name: " + employeeName + " | Salary: " + salary);
    }
}

class Pharmacist extends Employee { // CHILD CLASS
    private String licenseNo;

    Pharmacist(int employeeId, String employeeName, double salary, String licenseNo) {
        super(employeeId, employeeName, salary); // calls super class constructor
        this.licenseNo = licenseNo;
    }

    void displayPharmacist() {
        displayEmployee(); // inherited method
        System.out.println("License No: " + licenseNo);
    }
}

public class SingleInheritanceMain {
    public static void main(String[] args) {
        System.out.println("Super class: Employee | Child class: Pharmacist");
        Pharmacist p = new Pharmacist(21, "Anita", 35000, "LIC-1234");
        p.displayPharmacist();
    }
}

// ===== FILE: HierarchicalMain.java =====
// Q14. Hierarchical Inheritance - Person -> Doctor and Nurse
class Person { // SUPER CLASS
    protected String name;
    protected int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayPerson() {
        System.out.println("Name: " + name + " | Age: " + age);
    }
}

class Doctor extends Person { // CHILD CLASS 1
    private String specialization;

    Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    void displayDoctor() {
        displayPerson();
        System.out.println("Specialization: " + specialization);
    }
}

class Nurse extends Person { // CHILD CLASS 2
    private String ward;

    Nurse(String name, int age, String ward) {
        super(name, age);
        this.ward = ward;
    }

    void displayNurse() {
        displayPerson();
        System.out.println("Ward: " + ward);
    }
}

public class HierarchicalMain {
    public static void main(String[] args) {
        System.out.println("Super class: Person | Child classes: Doctor, Nurse");
        Doctor d = new Doctor("Dr. Mehta", 45, "Cardiology");
        Nurse n = new Nurse("Sister Rita", 32, "ICU");
        d.displayDoctor();
        n.displayNurse();
    }
}

// ===== FILE: MultilevelMain.java =====
// Q15. Multilevel Inheritance - Person -> Employee -> Manager
class Person { // LEVEL 1: top-level super class
    protected String name;
    protected int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Employee extends Person { // LEVEL 2: child of Person, super class of Manager
    private int employeeId;

    Employee(String name, int age, int employeeId) {
        super(name, age);
        this.employeeId = employeeId;
    }

    protected int getEmployeeId() { return employeeId; }
}

class Manager extends Employee { // LEVEL 3: final child class
    private int teamSize;

    Manager(String name, int age, int employeeId, int teamSize) {
        super(name, age, employeeId);
        this.teamSize = teamSize;
    }

    void displayManager() {
        System.out.println("Name: " + name + " | Age: " + age);
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Team Size: " + teamSize);
    }
}

public class MultilevelMain {
    public static void main(String[] args) {
        System.out.println("Person = top-level super class, Employee = intermediate child/super class, Manager = final child class");
        Manager m = new Manager("Vikas", 40, 501, 8);
        m.displayManager();
    }
}

// ===== FILE: MedicalStaffMain.java =====
// Q16. Protected Parent + Private Child Data
class MedicalStaff { // super class
    protected int staffId;
    protected String staffName;

    MedicalStaff(int staffId, String staffName) {
        this.staffId = staffId;
        this.staffName = staffName;
    }
}

class Doctor extends MedicalStaff {
    private String specialization; // private child data

    Doctor(int staffId, String staffName, String specialization) {
        super(staffId, staffName);
        this.specialization = specialization;
    }

    void displayDoctor() {
        // protected inherited fields used directly + own private field
        System.out.println("Doctor -> ID: " + staffId + " | Name: " + staffName + " | Specialization: " + specialization);
    }
}

class Pharmacist extends MedicalStaff {
    private String licenseNo; // private child data

    Pharmacist(int staffId, String staffName, String licenseNo) {
        super(staffId, staffName);
        this.licenseNo = licenseNo;
    }

    void displayPharmacist() {
        System.out.println("Pharmacist -> ID: " + staffId + " | Name: " + staffName + " | License: " + licenseNo);
    }
}

public class MedicalStaffMain {
    public static void main(String[] args) {
        Doctor d = new Doctor(1, "Dr. Sharma", "Neurology");
        Pharmacist p = new Pharmacist(2, "Meena", "LIC-4455");
        d.displayDoctor();
        p.displayPharmacist();
    }
}

// ===== FILE: InheritanceConceptMain.java =====
// Q17. Multiple and Hybrid Inheritance - Concept Only
/*
 * MULTIPLE INHERITANCE (of classes):
 * It means one class inherits from more than one parent class at the same time.
 *
 * Java does NOT allow a class to extend two classes. The invalid idea would be:
 *      class C extends A, B   // NOT allowed in Java (shown only as a comment)
 *
 * Why not? If A and B both have a method with the same name (say show()),
 * C would not know which one to inherit. This is the "diamond problem" and
 * causes ambiguity, so Java avoids it for classes.
 *
 * HYBRID INHERITANCE:
 * It is a combination of two or more forms of inheritance, for example
 * hierarchical + multiple, or multilevel + multiple. Since it usually
 * involves multiple inheritance of classes, it is also not possible with
 * classes alone in Java.
 *
 * Interfaces are commonly used when Java needs multiple/hybrid inheritance
 * of type/behavior (a class can implement many interfaces). This lab does
 * not create or implement any interface.
 */
public class InheritanceConceptMain {
    public static void main(String[] args) {
        System.out.println("See the comments above: Java does not support multiple inheritance of classes.");
    }
}

// ===== FILE: ShapeMain.java =====
// Q18. Shape Hierarchy - Parent Reference Array
class Shape { // super class
    protected String name;

    Shape(String name) {
        this.name = name;
    }

    void displayShapeName() {
        System.out.println("Shape: " + name);
    }
}

class Circle extends Shape {
    private double radius;

    Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle(String name, double length, double width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class ShapeManager {
    void displayAreas(Shape[] shapes) {
        for (int i = 0; i < shapes.length; i++) { // local loop variable
            shapes[i].displayShapeName();
            // Identify the actual child object before calling its area method
            if (shapes[i] instanceof Circle) {
                Circle c = (Circle) shapes[i];
                System.out.println("Area: " + c.calculateArea());
            } else if (shapes[i] instanceof Rectangle) {
                Rectangle r = (Rectangle) shapes[i];
                System.out.println("Area: " + r.calculateArea());
            }
        }
    }
}

public class ShapeMain {
    public static void main(String[] args) {
        // Parent-type array holding child objects
        Shape[] shapes = { new Circle("Circle", 7), new Rectangle("Rectangle", 5, 3) };
        new ShapeManager().displayAreas(shapes);
    }
}

// ===== FILE: HospitalStaffMain.java =====
// Q19. Hospital Staff Management - Integrated OOP
class Person { // top-level super class
    protected String name;
    protected int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Employee extends Person { // child of Person
    private int employeeId;
    private double salary;
    static int employeeCount = 0; // class variable shared by all employees

    Employee(String name, int age, int employeeId, double salary) {
        super(name, age);
        this.employeeId = employeeId;
        this.salary = salary;
        employeeCount++;
    }

    public int getEmployeeId() { return employeeId; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary rejected.");
        }
    }

    void displayEmployee() {
        System.out.println("Name: " + name + " | Age: " + age + " | ID: " + employeeId + " | Salary: " + salary);
    }
}

class Doctor extends Employee { // descendant of Person through Employee
    private String specialization;

    Doctor(String name, int age, int employeeId, double salary, String specialization) {
        super(name, age, employeeId, salary);
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
}

class Pharmacist extends Employee { // descendant of Person through Employee
    private String licenseNo;

    Pharmacist(String name, int age, int employeeId, double salary, String licenseNo) {
        super(name, age, employeeId, salary);
        this.licenseNo = licenseNo;
    }

    public String getLicenseNo() { return licenseNo; }
    public void setLicenseNo(String licenseNo) { this.licenseNo = licenseNo; }
}

class StaffManager { // all business logic is here
    void displayStaff(Employee[] staff) {
        for (int i = 0; i < staff.length; i++) {
            // Condition used to identify the role
            if (staff[i] instanceof Doctor) {
                Doctor d = (Doctor) staff[i];
                System.out.println("[Doctor] Specialization: " + d.getSpecialization());
            } else if (staff[i] instanceof Pharmacist) {
                Pharmacist p = (Pharmacist) staff[i];
                System.out.println("[Pharmacist] License: " + p.getLicenseNo());
            }
            staff[i].displayEmployee();
        }
    }

    void displayHighEarners(Employee[] staff, double limit) {
        System.out.println("Staff earning above " + limit + ":");
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getSalary() > limit) { // filtering condition
                staff[i].displayEmployee();
            }
        }
    }
}

public class HospitalStaffMain {
    public static void main(String[] args) {
        System.out.println("Person = top-level super class; Doctor/Pharmacist = descendants through Employee");
        Employee[] staff = {
            new Doctor("Dr. Mehta", 45, 1, 90000, "Cardiology"),
            new Pharmacist("Sneha", 29, 2, 35000, "LIC-9988")
        };
        StaffManager manager = new StaffManager();
        manager.displayStaff(staff);
        manager.displayHighEarners(staff, 50000);
        System.out.println("Total employees: " + Employee.employeeCount);
    }
}

// ===== FILE: PharmacyEmployeeMain.java =====
// Q20. Final Challenge - Pharmacy Employee Management System
class Employee { // super class
    private int employeeId;        // private instance variables (encapsulation)
    private String employeeName;
    private double salary;
    static int employeeCount = 0;  // class (static) variable shared by all objects

    Employee(int employeeId, String employeeName, double salary) {
        this.employeeId = employeeId;     // 'this' for instance variables
        this.employeeName = employeeName;
        this.salary = salary;
        employeeCount++;
    }

    // Public getters and setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (salary >= 0) {            // reject negative salary
            this.salary = salary;
        } else {
            System.out.println("Negative salary rejected for " + employeeName);
        }
    }

    // Protected method: child classes override it to give their own role title
    protected String getRoleTitle() {
        return "Employee";
    }

    // Default-access method (no access keyword): usable within the same package
    double calculateAnnualSalary() {
        return salary * 12;
    }

    public void displayEmployee() {
        System.out.println(getRoleTitle() + " -> ID: " + employeeId + " | Name: " + employeeName + " | Monthly Salary: " + salary);
    }
}

class Pharmacist extends Employee { // child class 1
    private String licenseNo;

    Pharmacist(int employeeId, String employeeName, double salary, String licenseNo) {
        super(employeeId, employeeName, salary); // parent initialization
        this.licenseNo = licenseNo;
    }

    @Override
    protected String getRoleTitle() { return "Pharmacist"; }

    public void showLicense() { // role-specific method
        System.out.println("   License No: " + licenseNo);
    }
}

class StoreManager extends Employee { // child class 2
    private int storeSection;

    StoreManager(int employeeId, String employeeName, double salary, int storeSection) {
        super(employeeId, employeeName, salary);
        this.storeSection = storeSection;
    }

    @Override
    protected String getRoleTitle() { return "Store Manager"; }

    public void showSection() { // role-specific method
        System.out.println("   Store Section: " + storeSection);
    }
}

class EmployeeProcessor { // separate manager/utility class
    void processEmployees(Employee[] employees) {
        double totalSalary = 0; // local variable (total)
        int pharmacistCount = 0; // local variable (counter)

        for (int i = 0; i < employees.length; i++) { // loop through all employees
            employees[i].displayEmployee();

            // Condition to identify role
            if (employees[i] instanceof Pharmacist) {
                ((Pharmacist) employees[i]).showLicense();
                pharmacistCount++;
            } else if (employees[i] instanceof StoreManager) {
                ((StoreManager) employees[i]).showSection();
            }

            totalSalary += employees[i].getSalary(); // controlled access via getter
            System.out.println("   Annual Salary: " + employees[i].calculateAnnualSalary());
        }

        System.out.println("Total monthly salary: " + totalSalary);
        System.out.println("Number of pharmacists: " + pharmacistCount);
        System.out.println("Total employees created: " + Employee.employeeCount);
    }

    void tryUpdateSalary(Employee e, double newSalary) {
        e.setSalary(newSalary); // setter validates the value
    }
}

public class PharmacyEmployeeMain {
    public static void main(String[] args) {
        Employee[] employees = {
            new Pharmacist(1, "Sneha", 35000, "LIC-1122"),
            new StoreManager(2, "Rohit", 45000, 3)
        };
        EmployeeProcessor processor = new EmployeeProcessor();
        processor.processEmployees(employees);
        processor.tryUpdateSalary(employees[0], -500);   // rejected
        processor.tryUpdateSalary(employees[0], 38000);  // accepted
        processor.processEmployees(employees);
    }
}
