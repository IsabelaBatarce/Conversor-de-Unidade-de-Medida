package converters;

public class YardConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value * 1.094;
    }

    public double toBasicUnit(double value) {
        return value / 1.094;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString() {
        String textComboBox = String.format("yard (yd) [%s]: %s", MeasureType.DISTANCE.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}