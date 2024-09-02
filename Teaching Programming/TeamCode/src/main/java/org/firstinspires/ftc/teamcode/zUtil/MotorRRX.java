package org.firstinspires.ftc.teamcode.zUtil;

//Hello! Welcome to the Ridgeview Robotics Extended Motor Class.
//This location serves as a hub to analyze and reference any necessary code that pertains to a DcMotor
//Feel free to reference this file at any time.

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class MotorRRX {

    private final double  ticksPerRev = 5281; //GoBILDA 312RPM DC Motor 5204
    public double ticksPerMM; //these two lines allow us to create some variables for tracking a motor

    private final DcMotorEx rcsMotor;

    public MotorRRX(HardwareMap hardwareMap, String motorName, double ratio){
        //everytime that a new Motor is declared, it requires the hardware map and a given 'name'
        rcsMotor = hardwareMap.get(DcMotorEx.class, motorName); //this motorName should match the
        //onboard configuration of the robot

        rcsMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);  //when motor is init, it will reset position
        rcsMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER); //post-reset, the motor will run with encoder data available
        rcsMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE); //when motor power = 0 motor will actively stop or slow down
        rcsMotor.setDirection(DcMotorEx.Direction.FORWARD); //motor will default to forward direction
        //if you use any of these commands for a motor in a separate declaration, ensure that you
        //instantiate the motor before you run those commands, as it will execute these commands first.

        ticksPerMM = (ticksPerRev) / (ratio * Math.PI);  //MATH TBD
    }

    public void runToPosition(int targetCts){
        int newTarget = rcsMotor.getCurrentPosition() + (targetCts);//new target = current encoder Pos + target
        rcsMotor.setTargetPosition(newTarget); //runs to new target
        rcsMotor.setPower(targetCts);
    }

    public int getPos(){
        return rcsMotor.getCurrentPosition(); //returns the current motor position as an integer
    }  //This method is only useful when in mode that uses the encoder system

    public void setPower(double power){
        rcsMotor.setPower(power); //assigns the power to the motor as a scale of 0.0->1.0
    }  //This method must be used for a motor to operate.

    public void resetEncoder(){
        rcsMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER); //resets the encoder
    }

    public void setReverse(){
        rcsMotor.setDirection(DcMotorEx.Direction.REVERSE);
        //reverses the direction of the motor.  Power application is the same.
    }

    public double getPower(){
        return rcsMotor.getPower();
        //allows for the output of motor power draw in telemetry.
    }

    public void setTargetPos(int target){
        rcsMotor.setTargetPosition(target);
        //sets the target position of the motor only when in RUN_TO_POSITION mode.
    }

    public void setTargetPosTolerance(int tolerance){ //unit: ticks
        rcsMotor.setTargetPositionTolerance(tolerance);
    }//Reassigns the tolerance that the PIDF controller can work within when running to a position

    public void setPIDFCoEff(DcMotorEx.RunMode runMode, PIDFCoefficients coEff){
        rcsMotor.setPIDFCoefficients(runMode, coEff);
    }//changes the PIDF coefficients for the chosen run mode.

    public PIDFCoefficients getPIDFCoEff(DcMotorEx.RunMode runMode){
        return rcsMotor.getPIDFCoefficients(runMode);
    } //accesses active PIDF Coefficients from the chosen run mode to change them.

    public void setBrakeBehavior(DcMotorEx.ZeroPowerBehavior zeroPowerBehavior){
        rcsMotor.setZeroPowerBehavior(zeroPowerBehavior);
    } //Allows for the dynamic application of the zeroPower/Brake Behavior.
    //The Options are:
    //Brake - The motor will slow down when there is no power flowing into the motor
    //Float - The motor will neither slow down nor speed up, friction will be the only thing acting on it.

    public void setMotorBehavior(DcMotor.RunMode runMode){
        rcsMotor.setMode(runMode);
    } //Allows for the dynamic application of RunModes.
    //The Options are:
    //RUN_WITHOUT_ENCODER, This mode does not utilize the encoder and will attempt to match input with voltage.
    //RUN_WITH_ENCODER, This mode utilizes the encoder to match input with the rev-counter.  This mode will not work without an encoder cable
    //RUN_TO_POSITION, This mode utilizes the encoder and a pre-set power to run the motor to the given position.
}


