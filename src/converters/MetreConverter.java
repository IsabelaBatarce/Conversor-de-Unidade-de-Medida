package converters;

public class MetreConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value;
    }

    public double toBasicUnit(double value) {
        return value;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString()
    {
        String textComboBox = String.format("metre (m) [%s]: %s", MeasureType.DISTANCE.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}