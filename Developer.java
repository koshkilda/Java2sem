import java.util.Scanner;

class Developer {

    String name;
    String level;
    int    work_experience;
    String set_of_technologies;

    public Developer(String name, String level, int work_experience, String set_of_technologies) 
    {
        this.name                = name;
        this.level               = level;
        this.work_experience     = work_experience;
        this.set_of_technologies = set_of_technologies;
    }

    public void writeCode()
    {
        System.out.println("Разработчик начал писать код.");
    }
}

class JavaDeveloper extends Developer 
{
    public JavaDeveloper(String name, String level, int work_experience, String set_of_technologies) 
    {
        super(name, level, work_experience, set_of_technologies);
    }

    @Override
    public void writeCode() 
    {
        System.out.println("Разработчик начал писать код.");
        System.out.println("Технологии, которые разработчик использует: " + set_of_technologies + ".");
    }
}

class PythonDeveloper extends Developer 
{
    public PythonDeveloper(String name, String level, int work_experience, String set_of_technologies) 
    {
        super(name, level, work_experience, set_of_technologies);
    }

    @Override
    public void writeCode() 
    {
        System.out.println("Разработчик начал писать код.");
        System.out.println("Информация о разработчике: " + name + ", " + level + ", " + work_experience + " лет -- стаж работы разработчика.");
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("С каким языком программирования должен работать разработчик?");
        String language = sc.nextLine();

        System.out.println("Имя разработчика?");
        String name = sc.nextLine();

        System.out.println("Уровень разработчика?");
        String level = sc.nextLine();

        System.out.println("Стаж разработчика?");
        String work_experience_str = sc.nextLine();
      
        int work_experience = Integer.parseInt(work_experience_str.trim());

        System.out.println("Набор технологий разработчика?");
        String set_of_technologies = sc.nextLine();

        if (language.equals("Java") == true) 
        {
            JavaDeveloper developer = new JavaDeveloper(name, level, work_experience, set_of_technologies);
            developer.writeCode();
        } 

        else if (language.equals("Python") == true) 
        {
            PythonDeveloper developer = new PythonDeveloper(name, level, work_experience, set_of_technologies);
            developer.writeCode();
        } 

        else 
        {
            System.out.println("У нас нет таких разработчиков...");
        }

        sc.close();
    }
}
