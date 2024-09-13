package org.firstinspires.ftc.teamcode._0_Onboarding;

//Welcome to Lesson 2.  In this lesson we will be introducing java as a language, and in the FTC context

public class Lesson_2 {  //Here is our first class, as you can see it comprises of 3 primary pieces:
    //public is our access modifier.  It declares that this class can be accessed from anywhere.
    //class is as it says, it is the definition, and our opening statement.
    //Lesson_2 is the chosen name of our class here.

private static class Human {//This is not a standard procedure, however for the sake of this lesson,
    // we will be creating a second class here.  See how everything has changed?  We now have two
    //primary differences.  This class has a private access modifier.  Not every class can gain
    //access to this class that we have defined here.  It is also static.  The static modifier is
    //used only when a variable or class is created inside of another class.  Adding a static modifier
    //allows the class or variable to be referenced anywhere in your code, without having to call
    //its entire class of origin, enhancing readability and memory efficiency.

    public String mName;
    public int mAge;
    public double mHeightMeters;
    public boolean mAlive; //These are called member variables.  These variables will be accessible
    //anywhere in the code

    //Now, let's begin!

    private Human(String name, int age, double heightMeters, boolean alive){//here we have made "local
        //variables"  They only apply in the constructor.
        //welcome to the constructor.  This is where we set the necessary parameters for every
        //class that we work with.  This 'Human' class, specifically, has 4 parameters.
        //These 4 Parameters are all of a different data type.  int(integers), are whole numbers.
        //doubles are all numbers, positive negative and decimal.  Strings are a series of characters
        //or words.  Booleans are true or false.
        mName = name;
        mAge = age;
        mHeightMeters = heightMeters;
        mAlive = alive; //As the local variables cannot be used anywhere but here, we now equate them
        //with our member variables, so that whatever values are attached to the Human clas, when
        //it is instantiated, they will be properly assigned.

    }

    //now that we have created sufficient variables, let's make a few methods, getters and setters.

    public void setName(String setName){
        mName = setName;
    }//This is a VOID.  This means that it completes an action of some kind.  This action, or Method
    //specifically is setting the Name of this human, to the given variable when the

    public void setAge(int setAge){
        mAge = setAge;
    }//All of these following Voids follow the same syntax around the same idea.

    public void setAlive(boolean setAlive){
        mAlive = setAlive;
    }

    public void setHeightMeters(double setHeightMeters){
        mHeightMeters = setHeightMeters;
    }


    public String getName(){
        return mName;
    }//these are identified as public Strings, ints, boolean, etc.  These functions are defined by
    //the variable type that they return respectively.

    public int getAge(){
        return mAge;
    }

    public boolean getAlive(){
        return mAlive;
    }

    public double getHeightMeters(){
        return mHeightMeters;
    }
}



}
