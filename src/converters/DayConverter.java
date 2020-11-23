package converters;

public class DayConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value / 86400;
    }

    public double toBasicUnit(double value) {
        return value * 86400;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString() {
        String textComboBox = String.format("day (d) [%s]: %s", MeasureType.TIME.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}