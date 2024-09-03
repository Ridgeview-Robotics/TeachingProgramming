package org.firstinspires.ftc.teamcode.zUtil;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoRRX {

    Servo rcsServo;

    public ServoRRX(HardwareMap hardwareMap, String servoName){
        rcsServo = hardwareMap.get(Servo.class, servoName);
    }

    public void setPosition(double pos){
        rcsServo.setPosition(pos);
    }//sets the position of the servo.

    public double getServoPosition(){
        return rcsServo.getPosition();
    }//returns the current position of the servo.

    public void setDirection(Servo.Direction direction){
        rcsServo.setDirection(direction);
    } //To change the direction of the servo if necessary

    public void setServoRange(double min, double max){
        rcsServo.scaleRange(min, max);
    }//limits servo range from 0.0 to min, and down from 1.0 to max.
    //if you were to set the range to 0.4 to 0.6, the tick from the servo would have 0.0 = 0.4 and 1.0 = 0.6.

}
