package frc.robot;
import edu.wpi.first.wpilibj.XboxController;

public class Controller {
    XboxController drive_controller = new XboxController(0);

    public double getDriveX() {
        return drive_controller.getLeftX();
    }

    public double getDriveY() {
        if (Math.abs(drive_controller.getLeftY()) > 0.2) {
            return drive_controller.getLeftY();
        } else {
            return 0d;
        }
    }
    
    public double getBucketTilt() {
        if (Math.abs(drive_controller.getRightY()) > 0.2) {
            return drive_controller.getRightY();
        } else {
            return 0d;
        }
    }
}
