package converters;

public class HourConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value / 3600;
    }

    public double toBasicUnit(double value) {
        return value * 3600;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString()
    {
        String textComboBox = String.format("hour (h) [%s]: %s", MeasureType.TIME.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}