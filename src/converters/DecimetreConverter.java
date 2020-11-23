package converters;

public class DecimetreConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value * 10;
    }

    public double toBasicUnit(double value) {
        return value / 10;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString() {
        String textComboBox = String.format("decimetre (dm) [%s]: %s", MeasureType.DISTANCE.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}