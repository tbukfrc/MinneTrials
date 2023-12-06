package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Bucket {
    private static WPI_TalonFX bucketFlipper = new WPI_TalonFX(8);
    private final double gF = 0.1;
    private final double gP = 0.1;
    private double bucketPos = 0;
    public void initMotors() {
        bucketFlipper.configFactoryDefault();
        bucketFlipper.setInverted(false);
        bucketFlipper.setSensorPhase(false);
        bucketFlipper.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        bucketFlipper.config_kF(0, gF);
        bucketFlipper.config_kP(0, gP);
        bucketFlipper.setNeutralMode(NeutralMode.Coast);
        bucketPos = 0d;
    };
    public void flipBucket(double turnSpeed) {
        if (turnSpeed > 0.1) {
            bucketPos -= 200;
        } else if (turnSpeed < -0.1) {
            bucketPos += 200;
        }
        bucketFlipper.set(TalonFXControlMode.Position, bucketPos);
        System.out.println(turnSpeed);
    }
}
