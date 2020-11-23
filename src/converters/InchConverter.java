package converters;

public class InchConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value * 39.37;
    }

    public double toBasicUnit(double value) {
        return value / 39.37;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString() {
        String textComboBox = String.format("inch (in) [%s]: %s", MeasureType.DISTANCE.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}