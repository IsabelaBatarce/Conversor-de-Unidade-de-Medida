package converters;

public class WeekConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value / 604800;
    }

    public double toBasicUnit(double value) {
        return value * 604800;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString() {
        String textComboBox = String.format("week (w) [%s]: %s", MeasureType.TIME.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}