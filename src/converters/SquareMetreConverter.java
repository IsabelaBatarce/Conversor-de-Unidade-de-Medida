package converters;

public class SquareMetreConverter implements IConverterMaster {

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
        String textComboBox = String.format("square metre (m�) [%s]: %s", MeasureType.AREA.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}