package converters;

public class SecondConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value;
    }

    public double toBasicUnit(double value) {
        return value;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString() {
        String textComboBox = String.format("second (s) [%s]: %s", MeasureType.TIME.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}